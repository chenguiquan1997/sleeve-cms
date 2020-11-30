package io.github.talelin.latticy.service.imy;

import io.github.talelin.latticy.model.my.Category;
import io.github.talelin.latticy.model.my.Page;

import java.util.List;
import java.util.Map;

public interface ICategoryService {

    Page searchAllOneLevelCategories(Map<String,Integer> pageMap, Integer size);

    Page searchAllTwoLevelCategoriesByParentId(Map<String,Integer> pageMap,
                                               Integer size,Long ParentId);

    void update(Category category);

    void delete(Long id);

    void save(Category category);

    List<Category> searchGrid();

    void removeCategoryFromGrid(Long id);

    void addCategoryToGrid(Long id);

}
