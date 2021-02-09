package io.github.talelin.latticy.dto.my;

import lombok.Data;


import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Min;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class BannerItemDTO {

    @NotNull
    @Positive
    private Long id;
    /**
     * 图片地址
     */
    private String img;
    /**
     * 当前banner_item的唯一业务标识
     */
    @NotNull
    @NotEmpty
    private String keyword;
    /**
     * item类型，一共三种
     */
    private Integer type;

    /**
     * 当前bannerItem的类型名称
     */
    @NotNull
    @NotEmpty
    private String typeName;
    /**
     * item名称
     */
    @NotNull
    @NotEmpty
    private String name;
    /**
     * 关联banner表的外键
     */
    @NotNull
    @Positive
    private Long bannerId;
}
