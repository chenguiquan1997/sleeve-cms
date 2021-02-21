package io.github.talelin.latticy.service.impl.my;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.common.exception.AddException;
import io.github.talelin.latticy.mapper.my.CategoryMapper;
import io.github.talelin.latticy.model.my.Category;
import io.github.talelin.latticy.service.imy.ICategoryService;
import org.junit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
// @Rollback 与 @Transactional 需要联合使用，才能达到数据回滚的效果
@Transactional
@Rollback
class CategoryServiceImplTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ICategoryService categoryService;

    //@BeforeClass 被 @BeforeAll 替代
    @BeforeAll
    public static void beforeClass() {
        System.out.println("BeforeClass 执行");
    }

    @BeforeEach
    public void before() {
        System.out.println("Before 执行");
    }

    /**
     * 在junit5中，@After注解被@AfterEach注解所替代
     */
    @AfterEach
    public void after() {
        System.out.println("After 执行");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("AfterClass 执行");
    }



    @Test
    void searchAllOneLevelCategories() {
    }

    @Test
    void searchAllTwoLevelCategoriesByParentId() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        /**
         * 存在当前id
         */
        Boolean thrown1 = false;
        Long id1 = new Long(1L);
        try{
            categoryService.delete(id1);
        }catch (NotFoundException e) {
            thrown1 = true;
        }
        categoryService.delete(id1);
        QueryWrapper<Category> q = new QueryWrapper<>();
        q.eq("id",id1).eq("delete_time",null);
        Category c = categoryMapper.selectOne(q);
        List<Category> c1 = categoryMapper.searchTwoLevelByParentId(1,10,id1);
        Assert.assertEquals(null,c);
        Assert.assertFalse(thrown1);
        Assert.assertEquals(0,c1.size());

        /**
         * 当前id不存在
         */
        Boolean thrown2 = false;
        Long id2 = new Long(-1L);
        //删除不成功
        try{
            categoryService.delete(id2);
        }catch (NotFoundException e) {
            thrown2 = true;
        }
        assertTrue(thrown2);
    }

    @Test
    void save() {
        Category c = Category.builder().name("测试save分类").isRoot(1).level(1).build();
        int res = categoryMapper.insert(c);
        System.out.println("res: "+res);
        Assert.assertEquals(1,res);
    }

    @Test
    void searchGrid() {
        List<Category> categories = categoryService.searchGrid();
        Assert.assertEquals(5,categories.size());
    }

    @Test
    void removeCategoryFromGrid() {
        //当前分类id存在
        Long id1 = new Long(2);
        categoryService.removeCategoryFromGrid(id1);
        List<Category> categories1 = categoryService.searchGrid();
        Assert.assertEquals(3,categories1.size());

        //当前分类id不存在
        Long id2 = new Long(-1);
        boolean thrown1 = false;
        try {
            categoryService.removeCategoryFromGrid(id2);
        }catch (NotFoundException e) {
            thrown1 = true;
        }
        Assert.assertTrue(thrown1);
        List<Category> categories2 = categoryService.searchGrid();
        Assert.assertEquals(3,categories2.size());

        //当前分类已经被删除
        Long id3 = new Long(1);
        boolean thrown2 = false;
        try {
            categoryService.removeCategoryFromGrid(id2);
        }catch (NotFoundException e) {
            thrown2 = true;
        }
        Assert.assertTrue(thrown2);
        List<Category> categories3 = categoryService.searchGrid();
        Assert.assertEquals(3,categories3.size());
    }

    @Test
    void addCategoryToGrid() {
        //添加一个已经被删除的分类
        boolean thrown1 = false;
        try{
            categoryService.addCategoryToGrid(1L);
        }catch (NotFoundException e) {
            thrown1 = true;
        }
        Assert.assertTrue(thrown1);

        //六宫格已满6个，继续添加，抛异常
        boolean thrown2 = false;
        try {
            categoryService.addCategoryToGrid(32L);
        }catch (AddException e) {
            thrown2 = true;
        }
        Assert.assertTrue(thrown2);

        //添加一个二级商品分类，抛出异常
        boolean thrown3 = false;
        try {
            categoryService.addCategoryToGrid(8L);
        }catch (AddException e) {
            thrown3 = true;
        }
        Assert.assertTrue(thrown3);
    }



}