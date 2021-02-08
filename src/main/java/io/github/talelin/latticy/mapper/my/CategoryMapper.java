package io.github.talelin.latticy.mapper.my;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.my.Category;
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
     * @param page
     * @param size
     * @param parentId
     * @return
     */
    List<Category> searchTwoLevelByParentId(@Param("page") Integer page,
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
}
