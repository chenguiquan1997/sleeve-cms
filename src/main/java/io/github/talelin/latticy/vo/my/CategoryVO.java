package io.github.talelin.latticy.vo.my;

import io.github.talelin.latticy.model.my.Category;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

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

    public CategoryVO(Category category) {
        BeanUtils.copyProperties(category,this);
    }
}
