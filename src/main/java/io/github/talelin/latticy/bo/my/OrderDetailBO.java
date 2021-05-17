package io.github.talelin.latticy.bo.my;

import io.github.talelin.latticy.model.my.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/5 18:03
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailBO extends BaseEntity {
    /**
     * id
     */
    private Long id;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 商品数量
     */
    private Integer totalCount;
    /**
     * 订单总金额
     */
    private BigDecimal totalPrice;
    /**
     * 订单实付总金额
     */
    private BigDecimal finalTotalPrice;
    /**
     * 订单中的商品信息集合
     */
    private List<ProductItemBO> productItems;
    /**
     * 顾客收货信息集合
     */
    private AddressBO address;
    /**
     * 订单状态
     */
    private String status;
    /**
     * 用户 id
     */
    private Long userId;
    /**
     * 微信支付时，预支付id
     */
    private String prepayId;
    /**
     * 下单时间
     */
    private Date placedTime;
    /**
     * 订单过期时间
     */
    private Date expireTime;
}
