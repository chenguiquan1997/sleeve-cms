package io.github.talelin.latticy.dto.my;

import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/3/23 11:06
 * @Version 1.0
 * 用于 SPU 更新时，接收前端传递的数据
 */
@Data
public class SpuUpdateDTO {
    /**
     * id
     */
    @NotNull
    @Positive
    private Long id;
    /**
     * spu 标题
     */
    @NotEmpty
    private String title;
    /**
     * 副标题
     */
    @NotEmpty
    private String subtitle;
    /**
     * 售价
     */
    @DecimalMax(value = "99999.99", message = "商品售价不可高于99999.99")
    @DecimalMin(value = "00.01", message = "商品售价不可低于0.01")
    @NotNull
    private BigDecimal price;
    /**
     * 折扣价
     */
    @DecimalMax(value = "99999.99", message = "商品折扣价不可高于99999.99")
    @DecimalMin(value = "00.00", message = "商品折扣价不可低于0.00")
    private BigDecimal discountPrice;
    /**
     * 父级分类 id
     */
    @NotNull
    @Positive
    private Long parentCategoryId;
    /**
     * 一级分类 id
     */
    @NotNull
    @Positive
    private Long rootCategoryId;
    /**
     * 默认 sku id
     */
    @Positive
    private Long defaultSkuId;
    /**
     * 可视化规格 id
     */
    @Positive
    private Long sketchSpecId;
    /**
     * 上下架标记
     */
    @NotNull
    private boolean online;
    /**
     * 主图 url
     */
    private String mainImgData;
    /**
     * 主题图 url
     */
    private String themeImgData;
    /**
     * 轮播图 url 集合
     */
    @NotEmpty
    private List<String> rotationImgData;
    /**
     * 详情图 url 集合
     */
    @NotEmpty
    private ArrayList<String> detailImgData;
    /**
     * 当前 SPU 所拥有的标签
     */
    private List<String> tagList;
    /**
     * 当前 SPU 所拥有的规格
     * 一个商品，如果一个规格都么有的话，个人认为是不现实的，所以商品所拥有的规格不能为空
     */
    @NotEmpty(message = "规格不能为空~")
    private List<Long> spuSpecs;
    /**
     * 描述
     */
    private String description;
}
