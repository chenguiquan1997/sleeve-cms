package io.github.talelin.latticy.bo.my;

import io.github.talelin.latticy.common.enumeration.my.OrderStatusEnum;
import io.github.talelin.latticy.model.my.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/11 17:17
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderSummaryBO {
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
     * 订单状态
     */
    private String status;
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

    /**
     * 将 Order 转换成 OrderSummaryBO
     * @param orders
     * @return
     */
    public static List<OrderSummaryBO> convert(List<Orders> orders) {
        List<OrderSummaryBO> orderSummaryBOS = new ArrayList<>();
        if(orders == null || orders.size() < 1) return orderSummaryBOS;
        orders.forEach(order -> {
            OrderSummaryBO orderSummaryBO = new OrderSummaryBO();
            BeanUtils.copyProperties(order,orderSummaryBO);
            String status = OrderStatusEnum.toType(order.getStatus()).getValue();
            orderSummaryBO.setStatus(status);
            orderSummaryBOS.add(orderSummaryBO);
        });
        return orderSummaryBOS;
    }
}
