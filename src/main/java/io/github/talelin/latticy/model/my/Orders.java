package io.github.talelin.latticy.model.my;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.talelin.latticy.common.util.GenericAndJson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/5 16:02
 * @Version 1.0
 * 订单实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orders extends BaseEntity implements Serializable {
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
    private String snapItems;
    /**
     * 顾客收货信息集合
     */
    private String snapAddress;
    /**
     * 用户 id
     */
    private Long userId;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 微信预支付 id
     */
    private String prepayId;
    /**
     * 订单过期时间
     */
    private Date expireTime;
    /**
     * 下单时间
     */
    private Date placedTime;
    /**
     * 订单概要
     */
    private String summaryTitle;
    /**
     * 收货人
     */
    private String receiver;
    /**
     * 联系电话
     */
    private String phone;

//    public Orders getSnapItems() {
//        Orders order = GenericAndJson.jsonToObject(this.snapItems,
//                new TypeReference<Orders>() {
//                });
//        return order;
//    }
//
//    public Orders getSnapAddress() {
//        if (this.snapAddress == null) {
//            return null;
//        }
//        Orders o = GenericAndJson.jsonToObject(this.snapAddress,
//                new TypeReference<Orders>() {
//                });
//        return o;
//    }
}
