package io.github.talelin.latticy.mapper.my;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.my.Category;
import io.github.talelin.latticy.bo.my.CategoryNameBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 查询所有一级分类
     * @param page
     * @param size
     * @return
     */
    List<Category> searchAllOneLevelCategories(@Param("page") Integer page,
                                               @Param("size") Integer size);

    /**
     * 获取一级分类的数量
     * @return
     */
    Integer getOneLevelCategoryCount();

    /**
     * 根据父级分类id，查询二级分类
     * @param startCount
     * @param size
     * @param parentId
     * @return
     */
    List<Category> searchTwoLevelByParentId(@Param("startCount") Integer startCount,
                                            @Param("size") Integer size,
                                            @Param("parentId") Long parentId);

    /**
     * 获取二级分类的数量
     * @return
     */
    Integer getTwoLevelCategoryCount(@Param("parentId") Long parentId);

    /**
     * 根据id删除指定商品分类
     * @param id
     * @param currTime
     */
    void logicalDeleteById(@Param("id") Long id, @Param("currTime") Date currTime);

    /**
     * 查询六宫格数据
     */
    List<Category> searchGrid();

    /**
     * 根据id，查询指定六宫格数据
     * @param id
     * @return
     */
    Category searchGridById(@Param("id") Long id);

    /**
     * 将指定分类从六宫格中剔除掉
     * @param categoryId 商品分类id
     */
    void removeCategryFromGrid(@Param("categoryId") Long categoryId);

    /**
     * 将指定分类加入到六宫格中
     * @param categoryId
     */
    void addCategryToGrid(@Param("categoryId") Long categoryId);

    /**
     * 查询六宫格内，当前拥有商品分类的数量
     * @return 属于六宫格的分类数量
     */
    Integer searchCategoryCountFromGrid();

    /**
     * 根据id查询分类明细
     * @param id
     * @return
     */
    Category getCategoryDetailById(@Param("id") Long id);

    /**
     * 根据父级id,获取父级分类名称
     * @param id
     * @return
     */
    String searchNameByParentId(@Param("parentId") Long id);

    /**
     * 根据分类 id 逻辑删除指定六宫格
     * @param id
     */
    void removeGridById(@Param("id") Long id);

    /**
     * 查询分类以及所属子分类
     * @param id 一级分类id
     * @return CategoryNameBO
     */
    CategoryNameBO searchCategoryAndChildren(@Param("rootCategoryId") Long id);
}
