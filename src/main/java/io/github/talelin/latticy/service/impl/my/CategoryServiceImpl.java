package io.github.talelin.latticy.service.impl.my;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.common.exception.AddException;
import io.github.talelin.latticy.common.exception.DeleteException;
import io.github.talelin.latticy.common.exception.SaveException;
import io.github.talelin.latticy.common.exception.UpdateException;;
import io.github.talelin.latticy.mapper.my.CategoryMapper;
import io.github.talelin.latticy.model.my.Category;
import io.github.talelin.latticy.model.my.Page;
import io.github.talelin.latticy.service.imy.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商品分类Service
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public Category queryOneCategoryMock(Long id) {
        QueryWrapper<Category> c = new QueryWrapper<>();
        c.eq("id",id).isNull("delete_time");
        Category category = categoryMapper.selectOne(c);
        return category;
    }

    /**
     * 查询所有一级分类数据
     * @return
     */
    @Override
    public Page searchAllOneLevelCategories(Map<String,Integer> pageMap, Integer size) {
       Integer count = categoryMapper.getOneLevelCategoryCount();
       if(count < 1) {
           return new Page<List>();
       }
       List<Category> categories = categoryMapper.searchAllOneLevelCategories(pageMap.get("startCount"),size);
       Page<List<Category>> categoryPage = new Page<>(count,categories,pageMap.get("currPage"),size);
       return categoryPage;
    }

    /**
     * 分页查询二级分类数据
     * @param pageMap
     * @param size
     * @param parentId 父级分类id
     * @return
     */
    @Override
    public Page searchAllTwoLevelCategoriesByParentId(Map<String, Integer> pageMap, Integer size, Long parentId) {
        Integer count = categoryMapper.getTwoLevelCategoryCount(parentId);
        if(count < 1) {
            return new Page<List>();
        }
        List<Category> categories = categoryMapper.searchTwoLevelByParentId(pageMap.get("startCount"),size, parentId);
        Page<List<Category>> categoryPage = new Page<>(count,categories,pageMap.get("currPage"),size);
        return categoryPage;
    }

    /**
     * 更新分类数据
     * @param category
     */
    public void update(Category category) {
        Category category1 = this.queryOneCategoryMock(category.getId());
        if(category1 == null) {
            throw new NotFoundException(22001);
        }
        try {
            categoryMapper.updateById(category);
        }catch (Exception e) {
            throw new UpdateException(21000);
        }
    }

    /**
     * 根据分类id，逻辑删除指定的商品分类；有子分类的，进行级联删除
     * @param id
     */
    @Override
    @Transactional //添加事务注解，因为需要有级联删除商品分类操作
    public void delete(Long id) {
        Category category = this.queryOneCategoryMock(id);
        if(category == null) {
            throw new NotFoundException(22001);
        }
        //查询当前分类是否存在子分类
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);
        List<Category> childrenCategories = categoryMapper.selectList(wrapper);
        //证明没有子分类
        Date currTime = new Date();
        try {
            if(childrenCategories == null || childrenCategories.size() < 1) {
                categoryMapper.logicalDeleteById(id,currTime);
            } else {
                //自身删除 + 级联删除
                categoryMapper.logicalDeleteById(id,new Date());
                for(Category c : childrenCategories) {
                    categoryMapper.logicalDeleteById(c.getId(),currTime);
                }
            }
        }catch (Exception e) {
            throw new DeleteException(21002);
        }
    }

    /**
     * 新增分类
     * @param category
     */
    @Override
    public void save(Category category) {
        //categoryMapper.insert(category);
        try{
            categoryMapper.insert(category);
        }catch (Exception e) {
            throw new SaveException(21001);
        }

    }

    /**
     * 查询六宫格数据
     */
    @Override
    public List<Category> searchGrid() {
        List<Category> categories = categoryMapper.searchGrid();
        return categories;
    }

    /**
     * 从六宫格中删除指定商品分类
     * @param id 商品分类id
     */
    @Override
    public void removeCategoryFromGrid(Long id) {
        Category category = this.queryOneCategoryMock(id);
        if(category == null) {
            throw new NotFoundException(22001);
        }
        try {
            categoryMapper.removeCategryFromGrid(id);
        }catch (Exception e) {
            throw new DeleteException(21002);
        }
    }

    /**
     * 将指定的商品分类添加到六宫格中
     */
    @Override
    public void addCategoryToGrid(Long id) {
        //首先查询当前分类是否存在,并且是否为一级分类
        QueryWrapper<Category> c = new QueryWrapper<>();
        c.eq("id",id).eq("is_root",1).isNull("delete_time");
        Category category = categoryMapper.selectOne(c);

        if(category == null) {
            throw new NotFoundException(22003);
        }
        //判断六宫格中的分类数量是否大于6
        Integer count = categoryMapper.searchCategoryCountFromGrid();
        if(count < 6) {
            //添加操作
            categoryMapper.addCategryToGrid(id);
        } else if(count >= 6) {
            throw new AddException(22002);
        }else {
            throw new AddException(21003);
        }
    }

}
