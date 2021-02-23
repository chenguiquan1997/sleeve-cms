package io.github.talelin.latticy.dto.my;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author Guiquan Chen
 * @Date 2021/2/22 14:56
 * @Version 1.0
 * 当前类用于新增分类时，接收前端的数据
 */
@Data
public class CategorySaveDTO {

    /**
     * 分类名称
     */
    @NotNull
    @NotEmpty
    private String name;
    /**
     * 分类描述
     */
    @NotNull
    @NotEmpty
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
    private Long parentId;
    /**
     * 图片
     */
    @NotNull
    @NotEmpty
    private String img;
    /**
     * 当前类别为第几级分类
     */
    @NotNull
    private Integer level;

}
