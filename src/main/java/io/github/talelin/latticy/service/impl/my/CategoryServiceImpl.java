package io.github.talelin.latticy.service.impl.my;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.bo.my.CategoryBO;
import io.github.talelin.latticy.common.exception.AddException;
import io.github.talelin.latticy.common.exception.DeleteException;
import io.github.talelin.latticy.common.exception.SaveException;
import io.github.talelin.latticy.common.exception.UpdateException;;
import io.github.talelin.latticy.dto.my.CategoryDTO;
import io.github.talelin.latticy.dto.my.CategorySaveDTO;
import io.github.talelin.latticy.dto.my.GridUpdateDTO;
import io.github.talelin.latticy.mapper.my.CategoryMapper;
import io.github.talelin.latticy.model.my.Category;
import io.github.talelin.latticy.bo.my.CategoryNameBO;
import io.github.talelin.latticy.model.my.Grid;
import io.github.talelin.latticy.model.my.Page;
import io.github.talelin.latticy.service.imy.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    /**
     * @Description: 根据分类id，查询唯一分类数据，每次进行分类数据的修改操作时，都需要先查询以下，有无当前数据
     * @param id 分类id
     * @return io.github.talelin.latticy.model.my.Category
     * @Author: Guiquan Chen
     * @Date: 2021/2/21
     */
    public Category queryOneCategoryMock(Long id) {
        QueryWrapper<Category> c = new QueryWrapper<>();
        c.eq("id",id).isNull("delete_time");
        Category category = categoryMapper.selectOne(c);
        return category;
    }

    /**
     * @Description: 查询所有一级分类数据
     * @param pageMap sql语句进行分页查询时，需要的两个参数
     * @param size 当前页数据量
     * @return io.github.talelin.latticy.model.my.Page
     * @Author: Guiquan Chen
     * @Date: 2021/2/21
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
     * 根据父级分类id,分页查询二级分类数据
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
     * @param categoryDTO
     */
    public void update(CategoryDTO categoryDTO) {
        // 不是一级分类，但是父级分类 id 为空
        if(categoryDTO.getIsRoot() != 1 && categoryDTO.getParentId() == null) {
            throw new UpdateException(22004);
        }
        //是一级分类，但是父级分类 id 不为空
        else if(categoryDTO.getIsRoot() == 1 && categoryDTO.getParentId() != null) {
            throw new UpdateException(22005);
        }
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO,category);
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
     * @param categorySaveDTO
     */
    @Override
    public void save(CategorySaveDTO categorySaveDTO) {
        // 不是一级分类，但是父级分类 id 为空
        if(categorySaveDTO.getIsRoot() != 1 && categorySaveDTO.getParentId() == null) {
            throw new SaveException(22004);
        }
        //是一级分类，但是父级分类 id 不为空
        else if(categorySaveDTO.getIsRoot() == 1 && categorySaveDTO.getParentId() != null) {
            throw new SaveException(22005);
        }
        Category category = new Category();
        BeanUtils.copyProperties(categorySaveDTO,category);
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

    @Override
    public Grid searchGridById(Long id) {
        if(id == null || id <= 0) throw new NotFoundException(22006);
        Category category = categoryMapper.searchGridById(id);
        Grid grid = new Grid();
        BeanUtils.copyProperties(category,grid);
        return grid;
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

    /**
     * 根据id查询当前分类详情
     * @param id
     * @return
     */
    @Override
    public CategoryBO getCategoryDetailById(Long id) {
        if(id == null  || id <= 0) throw new NotFoundException(22001);
        Category category = categoryMapper.getCategoryDetailById(id);
        if(category == null) {
            throw new NotFoundException(22001);
        }
        CategoryBO categoryBO = new CategoryBO();
        BeanUtils.copyProperties(category,categoryBO);
        Long parentId = category.getParentId();
        if(parentId != null) {
            String name = categoryMapper.searchNameByParentId(parentId);
            categoryBO.setParentName(name);
        }else {
            categoryBO.setParentName(new String("无"));
        }
        return categoryBO;
    }

    /**
     * 根据id,获取分类名称
     * @param parentId
     * @return
     */
    @Override
    public String searchNameByParentId(Long parentId) {
        String nullName = "无";
        if(parentId == null  || parentId <= 0) return nullName;
        String name = categoryMapper.searchNameByParentId(parentId);
        if(name == null) return nullName;
        return name;
    }

    /**
     * @Description: 根据 id 更新六宫格数据
     * @param gridUpdateDTO
     * @return:
     * @Author: Guiquan Chen
     * @Date: 2021/2/28
     */
    @Override
    public void updateGridById(GridUpdateDTO gridUpdateDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(gridUpdateDTO,category);
        UpdateWrapper<Category> wrapper = new UpdateWrapper<>();
        wrapper.eq("id",category.getId());
        wrapper.set("grid_online",category.getGridOnline())
                                           .set("grid_img",category.getGridImg());
        try {
            categoryMapper.update(category,wrapper);
        }catch (Exception e) {
            throw new UpdateException(21000);
        }

    }

    /**
     * @Description: 根据分类 id 删除指定六宫格数据
     * @param id 分类id
     * @return:
     * @Author: Guiquan Chen
     * @Date: 2021/3/1
     */
    @Override
    public void removeGridById(Long id) {
        try {
            categoryMapper.removeGridById(id);
        }catch (Exception e) {
            throw new DeleteException(21002);
        }
    }

    /**
     * @Description: 查询分类以及所属子分类
     * @return io.github.talelin.latticy.bo.my.CategoryNameBO
     * @Author: Guiquan Chen
     * @Date: 2021/3/15
     */
    @Override
    public List<CategoryNameBO> searchCategoryAndChildren() {
        // 获取所有一级分类
        QueryWrapper<Category> categoryWrapper1 = new QueryWrapper<>();
        categoryWrapper1.eq("is_root",1).isNull("delete_time");
        List<Category> categoryList = categoryMapper.selectList(categoryWrapper1);
        List<CategoryNameBO> categoryNameBOList = new ArrayList<>();
        // 循环执行内部
        if(categoryList == null || categoryList.size() < 1) return categoryNameBOList;
        categoryList.forEach(category -> {
            CategoryNameBO categoryName = new CategoryNameBO();
            categoryName.setValue(category.getId());
            categoryName.setLabel(category.getName());
            QueryWrapper<Category> categoryWrapper = new QueryWrapper<>();
            categoryWrapper.eq("parent_id",category.getId()).isNull("delete_time");
            List<Category> categories = categoryMapper.selectList(categoryWrapper);
            List<CategoryNameBO> categoryNameBOS = new ArrayList<>();
            if(categories != null && categories.size() > 0) {
                categories.forEach(category1 -> {
                    CategoryNameBO categoryNameBO = CategoryNameBO.builder()
                            .value(category1.getId())
                            .label(category1.getName()).build();
                    categoryNameBOS.add(categoryNameBO);
                });
                categoryName.setChildren(categoryNameBOS);
            }
            categoryNameBOList.add(categoryName);
        });

        return categoryNameBOList;
    }
}
