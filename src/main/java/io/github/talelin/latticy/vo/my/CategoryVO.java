package io.github.talelin.latticy.vo.my;

import io.github.talelin.latticy.model.my.Category;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CategoryVO {

    private Long id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 分类描述
     */
    private String description;
    /**
     * 当前分类是否为根节点（一级分类）
     */
    private Boolean isRoot;
    /**
     * 是否上线/是否显示
     */
    private Boolean online;
    /**
     * 父级分类id
     */
    private Long parentId;
    /**
     * 图片
     */
    private String img;
    /**
     * 当前类别为第几级分类
     */
    private Integer level;
    /**
     * 一级分类索引
     */
    private Integer idx;
    /**
     * 分类顶级图片
     */
    private String gridImg;
    /**
     * 是否属于六宫格中的分类
     */
    private Boolean isGrid;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 当前六宫格是否上线的标记
     */
    private Boolean gridOnline;

    /**
     * @Description: 构造方法内部将category转换成categoryVO
     * @param category
     * @Author: Guiquan Chen
     * @Date: 2021/2/21
     */
    public CategoryVO(Category category) {
        BeanUtils.copyProperties(category,this);
    }

    /**
     * @Description: 此方法用于将category集合，转换成cateoryVO集合
     * @param categories
     * @return java.util.List<io.github.talelin.latticy.vo.my.CategoryVO>
     * @Author: Guiquan Chen
     * @Date: 2021/2/21
     */
    public static List<CategoryVO> convertTypes(List<Category> categories) {
        List<CategoryVO> categoryVOS = new ArrayList<>();
        if(categories == null || categories.size() <1) {
            return categoryVOS;
        }
        for(Category c : categories) {
            CategoryVO categoryVO = new CategoryVO(c);
            categoryVOS.add(categoryVO);
        }
        return categoryVOS;
    }
}
