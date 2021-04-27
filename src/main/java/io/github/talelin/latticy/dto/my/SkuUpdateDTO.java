package io.github.talelin.latticy.dto.my;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/4/21 17:45
 * @Version 1.0
 * 更新SKU时，接收前端参数的DTO
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SkuUpdateDTO {
    /**
     * sku id
     */
    @NotNull
    @Positive
    private Long id;
    /**
     * 所属 SPU
     */
    @NotEmpty
    private String belongSpu;
    /**
     * spu id
     */
    @NotNull
    @Positive
    private Long spuId;
    /**
     * sku 编码
     */
    @NotEmpty
    private String code;
    /**
     * 当前 sku 折扣价
     * 如果没有也可以，如果有，不可以大于当前sku的实际价格
     * 需要写一个自定义注解
     */
    private BigDecimal discountPrice;
    /**
     * 主图
     */
    @NotEmpty
    private String img;
    /**
     * 是否上下架的标记
     */
    @NotNull
    private Boolean online;
    /**
     * 实际价格
     */
    @NotNull
    @Positive
    @DecimalMax(value = "99999.99", message = "商品售价不可高于99999.99")
    @DecimalMin(value = "00.01", message = "商品售价不可低于0.01")
    private BigDecimal price;
    /**
     * 库存
     */
    @NotNull
    @Positive
    private Integer stock;
    /**
     * 标题
     */
    @NotEmpty
    private String title;
    /**
     * 当前 sku 所拥有的规格
     */
    @NotNull
    private List<BelongSpec> belongSpecs;
}
