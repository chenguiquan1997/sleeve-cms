package io.github.talelin.latticy.service.imy;

import io.github.talelin.latticy.bo.my.OrderDetailBO;
import io.github.talelin.latticy.dto.my.ConditionSearchDTO;
import io.github.talelin.latticy.dto.my.OrderUpdateDTO;
import io.github.talelin.latticy.model.my.Page;

import java.util.Map;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/5 16:29
 * @Version 1.0
 */
public interface IOrderService {

    /**
     * 根据指定的条件，分页查询 order
     * @param pageMap 分页参数
     * @param size 每页数据量
     * @param conditionSearchDTO 封装 order 的查询条件
     */
    Page searchOrderListByPage(Map<String,Integer> pageMap, Integer size, ConditionSearchDTO conditionSearchDTO);

    /**
     * 根据 order id 查询指定订单详情
     * @param orderId
     * @return
     */
    OrderDetailBO searchOrderDetailById(Long orderId);

    /**
     * 更新订单信息
     * @param orderUpdateDTO
     */
    void updateOrder(OrderUpdateDTO orderUpdateDTO);
}
