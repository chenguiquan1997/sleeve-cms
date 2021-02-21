package io.github.talelin.latticy.service.imy;

import io.github.talelin.latticy.bo.my.CategoryBO;
import io.github.talelin.latticy.dto.my.CategoryDTO;
import io.github.talelin.latticy.model.my.Category;
import io.github.talelin.latticy.model.my.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ICategoryService {

    Page searchAllOneLevelCategories(Map<String,Integer> pageMap, Integer size);

    Page searchAllTwoLevelCategoriesByParentId(Map<String,Integer> pageMap,
                                               Integer size,Long ParentId);

    void update(CategoryDTO categoryDTO);

    void delete(Long id);

    void save(CategoryDTO categoryDTO);

    List<Category> searchGrid();

    void removeCategoryFromGrid(Long id);

    void addCategoryToGrid(Long id);

    /**
     * 根据id查询分类明细
     * @param id
     * @return
     */
    CategoryBO getCategoryDetailById(Long id);

    /**
     * 根据父级id,获取父级分类名称
     * @param id
     * @return
     */
    String searchNameByParentId(Long id);
}
