package io.github.talelin.latticy.dto.my;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CategoryDTO {

    /**
     * id
     */
    @NotNull
    private Long id;
    /**
     * 分类名称
     */
    @NotNull
    private String name;
    /**
     * 分类描述
     */
    private String description;
    /**
     * 当前分类是否为根节点（一级分类）
     */
    private Integer isRoot;
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

}
