package io.github.talelin.latticy.bo.my;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/10 11:39
 * @Version 1.0
 * 承装orders表中的snap_items字段下，各个商品的详情，业务实体类
 */
@Data
public class ProductItemBO {
    /**
     * sku id
     */
    private Long id;
    /**
     * 商品图片
     */
    private String img;
    /**
     * 购买的单一商品数量
     */
    private Integer count;
    /**
     * 商品概要描述
     */
    private String title;
    /**
     * 所属 SPU id
     */
    private Long spuId;
    /**
     * 商品挂牌价格
     */
    private BigDecimal singlePrice;
    /**
     * 商品交易价格
     */
    private BigDecimal finalPrice;
    /**
     * 商品规格
     */
    private List<String> specValues;
}
