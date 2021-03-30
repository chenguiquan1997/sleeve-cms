package io.github.talelin.latticy.service.imy;

import io.github.talelin.latticy.bo.my.CategoryBO;
import io.github.talelin.latticy.dto.my.CategoryDTO;
import io.github.talelin.latticy.dto.my.CategorySaveDTO;
import io.github.talelin.latticy.dto.my.GridUpdateDTO;
import io.github.talelin.latticy.model.my.Category;
import io.github.talelin.latticy.bo.my.CategoryNameBO;
import io.github.talelin.latticy.model.my.Grid;
import io.github.talelin.latticy.model.my.Page;

import java.util.List;
import java.util.Map;

public interface ICategoryService {

    Page searchAllOneLevelCategories(Map<String,Integer> pageMap, Integer size);

    Page searchAllTwoLevelCategoriesByParentId(Map<String,Integer> pageMap,
                                               Integer size,Long ParentId);

    void update(CategoryDTO categoryDTO);

    void delete(Long id);

    void save(CategorySaveDTO categorySaveDTO);

    List<Category> searchGrid();

    /**
     * 根据id，查询指定六宫格数据
     * @param id
     * @return
     */
    Grid searchGridById(Long id);

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

    void updateGridById(GridUpdateDTO gridUpdateDTO);

    void removeGridById(Long id);

    /**
     * 查询分类以及所属子分类
     * @return List<CategoryNameBO>
     */
    List<CategoryNameBO> searchCategoryAndChildren();
}
