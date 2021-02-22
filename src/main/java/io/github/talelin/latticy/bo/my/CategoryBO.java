package io.github.talelin.latticy.bo.my;

import lombok.Data;

@Data
public class CategoryBO {

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
     * 是否上线/是否显示
     */
    private Boolean online;
    /**
     * 父级分类id
     */
    private Long parentId;
    /**
     * 是否为一级分类
     */
    private Integer isRoot;
    /**
     * 图片
     */
    private String img;
    /**
     * 当前类别为第几级分类
     */
    private Integer level;
    /**
     * 父类名称
     */
    private String parentName;
}
