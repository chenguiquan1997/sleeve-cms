package io.github.talelin.latticy.bo.my;

import io.github.talelin.latticy.model.my.SkuSpec;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/4/12 17:33
 * @Version 1.0
 * SKU 详情的业务实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SkuBO {
    /**
     * id
     */
    private Long id;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 折扣价
     */
    private BigDecimal discountPrice;
    /**
     * 是否上架
     */
    private Boolean online;
    /**
     * 图片
     */
    private String img;
    /**
     * 标题
     */
    private String title;
    /**
     * 所属SPU id
     */
    private Long spuId;
    /**
     * 所属SPU 名称
     */
    private String belongSpu;
    /**
     * sku 拥有的规格
     */
    private String specs;
    /**
     * 当前sku 唯一识别码
     */
    private String code;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 当前sku所拥有的规格
     */
    private List<SkuSpec> skuSpecs;
}
