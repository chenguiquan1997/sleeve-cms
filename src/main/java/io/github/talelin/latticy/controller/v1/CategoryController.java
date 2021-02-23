package io.github.talelin.latticy.controller.v1;

import io.github.talelin.latticy.bo.my.CategoryBO;
import io.github.talelin.latticy.common.util.CommonUtils;
import io.github.talelin.latticy.dto.my.CategoryDTO;
import io.github.talelin.latticy.dto.my.CategorySaveDTO;
import io.github.talelin.latticy.model.my.Category;
import io.github.talelin.latticy.model.my.Page;
import io.github.talelin.latticy.service.imy.ICategoryService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import io.github.talelin.latticy.vo.my.CategoryDetailVO;
import io.github.talelin.latticy.vo.my.CategoryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/category")
@Validated
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    /**
     * 分页获取一级分类数据
     * @param page 当前页
     * @param count 每页查询数据量
     * @return
     */
    @GetMapping("/all/oneLevel")
    public Page searchOneLevelCategories(@RequestParam(name = "page",defaultValue = "1")
                                         @Min(value = 1) Integer page,
                                         @RequestParam(name = "count", defaultValue = "10")
                                         @Min(value = 3) @Max(value = 30) Integer count) {
        Map<String,Integer> pageMap = CommonUtils.convertPageParams(page,count);
        Page categories = categoryService.searchAllOneLevelCategories(pageMap,count);
        return categories;
    }

    /**
     * 根据父级分类id,分页获取二级商品分类数据
     * @param page
     * @param size
     * @param parentId
     * @return
     */
    @GetMapping("/all/twoLevel/{id}")
    public Page searchTwoLevelCategoriesByParentId(@RequestParam(name = "page",defaultValue = "1")
                                                   @Min(value = 1) Integer page,
                                                   @RequestParam(name = "size", defaultValue = "10")
                                                   @Min(value = 3) @Max(value = 30) Integer size,
                                                   @PathVariable(name = "id") @NotNull @Positive Long parentId) {
        Map<String,Integer> pageMap = CommonUtils.convertPageParams(page,size);
        Page categories = categoryService.searchAllTwoLevelCategoriesByParentId(pageMap,size,parentId);
        return categories;
    }

    /**
     * 根据分类Id，更新商品分类数据
     * @param categoryDTO
     * @return
     */
    @PutMapping("/update")
    public UpdatedVO updateCategoryInfoById(@RequestBody @Validated CategoryDTO categoryDTO) {
        categoryService.update(categoryDTO);
        return new UpdatedVO(2);
    }

    /**
     * 根据id，查询当前分类的明细
     * @param id
     * @return
     */
    @RequestMapping("/detail/{id}")
    public CategoryDetailVO getCategoryDetail(@PathVariable("id") @NotNull @Positive Long id) {
        CategoryBO bo = categoryService.getCategoryDetailById(id);
        return new CategoryDetailVO(bo);
    }

    /**
     * 根据分类id，逻辑删除指定的商品分类；有子分类的，进行级联删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public DeletedVO deleteCategoryById(@PathVariable(name = "id") @Positive @NotNull Long id) {
        categoryService.delete(id);
        return new DeletedVO(3);
    }

    /**
     * 新增分类
     * @param categorySaveDTO
     */
    @PostMapping("/save")
    public CreatedVO save(@RequestBody @Validated CategorySaveDTO categorySaveDTO) {
        categoryService.save(categorySaveDTO);
        return new CreatedVO(1);
    }

    /**
     * 查询六宫格数据
     * @return
     */
    @GetMapping("/grid")
    public List<CategoryVO> searchGrid() {
        List<Category> categories = categoryService.searchGrid();
        return CategoryVO.convertTypes(categories);
    }

    /**
     * 从六宫格中删除指定商品分类
     * @param id 商品分类id
     * @return
     */
    @DeleteMapping("/grid/remove/{id}")
    public DeletedVO removeFromGrid(@PathVariable(name = "id") @NotNull @Positive Long id) {
        categoryService.removeCategoryFromGrid(id);
        return new DeletedVO(3);
    }

    /**
     * 将指定的商品分类添加到六宫格中
     * @param id 商品分类id
     */
    @PutMapping("/grid/add/{id}")
    public CreatedVO addToGrid(@PathVariable(name = "id") @NotNull @Positive Long id) {
        categoryService.addCategoryToGrid(id);
        return new CreatedVO(21004);
    }

    /**
     * @Description: 根据id,获取分类名称
     * @param id 分类id
     * @return java.lang.String
     * @Author: Guiquan Chen
     * @Date: 2021/2/22
     */
    @RequestMapping("/name/{id}")
    public String searchParentCategoryName(@PathVariable("id") @NotNull @Positive Long id) {
       return categoryService.searchNameByParentId(id);
    }

}
