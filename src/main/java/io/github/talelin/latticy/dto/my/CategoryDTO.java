package io.github.talelin.latticy.dto.my;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class CategoryDTO {

    /**
     * id
     */
    @NotNull
    @Positive
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
    @NotNull
    @Max(value = 1)
    @Min(value = 0)
    private Integer isRoot;
    /**
     * 是否上线/是否显示
     */
    @NotNull
    private Boolean online;
    /**
     * 父级分类id
     */
    @NotNull
    private Long parentId;
    /**
     * 图片
     */
    private String img;
    /**
     * 当前类别为第几级分类
     */
    private Integer level;


}
