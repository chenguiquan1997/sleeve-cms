package io.github.talelin.latticy.service.impl.my;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.talelin.latticy.bo.my.*;
import io.github.talelin.latticy.common.enumeration.my.OrderStatusEnum;
import io.github.talelin.latticy.common.exception.AddException;
import io.github.talelin.latticy.common.exception.NotFoundException;
import io.github.talelin.latticy.common.exception.ParamException;
import io.github.talelin.latticy.common.exception.UpdateException;
import io.github.talelin.latticy.dto.my.ConditionSearchDTO;
import io.github.talelin.latticy.dto.my.OrderUpdateDTO;
import io.github.talelin.latticy.mapper.my.DeliveryMapper;
import io.github.talelin.latticy.mapper.my.OrderMapper;
import io.github.talelin.latticy.model.my.Delivery;
import io.github.talelin.latticy.model.my.Orders;
import io.github.talelin.latticy.model.my.Page;
import io.github.talelin.latticy.service.imy.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/5 16:30
 * @Version 1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private DeliveryMapper deliveryMapper;

    /**
     * @Description: 根据查询条件，分页查询订单概要数据
     * @param pageMap 分页参数
     * @param size 每页数据量
     * @param conditionSearchDTO 封装查询条件的对象
     * @return io.github.talelin.latticy.model.my.Page
     * @Author: Guiquan Chen
     * @Date: 2021/5/17
     */
    @Override
    public Page searchOrderListByPage(Map<String, Integer> pageMap, Integer size,
                                      ConditionSearchDTO conditionSearchDTO) {
        Integer count;
        ConditionSearchBO conditions = new ConditionSearchBO();
        if(conditionSearchDTO == null) {
            // 无条件查询
            conditions.setAllFlag(true);
        }else if(conditionSearchDTO.getOrderNo() != null) {
            // 根据订单号查询
            conditions.setOrderNo(conditionSearchDTO.getOrderNo());
        }else if(conditionSearchDTO.getPhone() != null) {
            // 根据手机号查询
            conditions.setPhone(conditionSearchDTO.getPhone());
        }else if(conditionSearchDTO.getReceiver() != null) {
            // 根据收货人进行查询
            conditions.setReceiver(conditionSearchDTO.getReceiver());
        }else if(conditionSearchDTO.getStatus() != null) {
            // 根据订单状态查询
            conditions.setStatus(conditionSearchDTO.getStatus());
        }else if(conditionSearchDTO.getStartTime() != null && conditionSearchDTO.getEndTime() != null) {
            if(conditionSearchDTO.getStartTime().after(conditionSearchDTO.getEndTime())) {
                log.error("时间参数错误，起始日期大于结束日期，startTime=[{}]，endTime=[{}]",conditionSearchDTO.getStartTime(),conditionSearchDTO.getEndTime());
                throw new ParamException(26001);
            }
            conditions.setStartTime(conditionSearchDTO.getStartTime());
            conditions.setEndTime(conditionSearchDTO.getEndTime());
        }
        count = orderMapper.getOrderTotalCount(conditions);
        if(count < 1) {
            return new Page(0,new ArrayList<>(),0,0);
        }
        List<Orders> orders = orderMapper.searchOrderListByPage(pageMap.get("startCount"),size,conditions);
        List<OrderSummaryBO> orderSummaryBOS = OrderSummaryBO.convert(orders);
        Page orderSummaryPage = new Page<>(count,orderSummaryBOS,pageMap.get("currPage"),size);
        return orderSummaryPage;
    }

    /**
     * @Description: 根据订单 id, 查询指定订单详情
     * @param orderId 订单id
     * @return io.github.talelin.latticy.bo.my.OrderDetailBO
     * @Author: Guiquan Chen
     * @Date: 2021/5/10
     */
    @Override
    public OrderDetailBO searchOrderDetailById(Long orderId) {
        Orders order = orderMapper.selectById(orderId);
        if(order == null) {
            log.info("当前订单不存在, orderId=[{}]",orderId);
            throw new NotFoundException(26003);
        }
        // 先把数据库中json格式的数据，转化为Json对象
        JSONArray j = JSONArray.parseArray(order.getSnapItems());
        JSONObject jsonObject = JSONObject.parseObject(order.getSnapAddress());
        // 再把Json对象，转换为业务实体类
        List<ProductItemBO> p = JSON.toJavaObject(j,List.class);
        AddressBO address = JSON.toJavaObject(jsonObject, AddressBO.class);
        OrderDetailBO orderDetailBO = new OrderDetailBO();
        BeanUtils.copyProperties(order,orderDetailBO);
        orderDetailBO.setAddress(address);
        orderDetailBO.setProductItems(p);
        orderDetailBO.setStatus(OrderStatusEnum.toType(order.getStatus()).getValue());
        // todo 一个订单可能会分成多个物流单发货
        String deliveryNo = deliveryMapper.searchDeliveryNoByOrderNo(order.getOrderNo());
        orderDetailBO.setDeliveryNo(deliveryNo);
        return orderDetailBO;
    }

    /**
     * @Description: 更新订单信息，以及为当前订单创建物流信息
     * @param orderUpdateDTO 订单数据参数
     * @return: null
     * @Author: Guiquan Chen
     * @Date: 2021/5/24
     */
    @Transactional
    public void updateOrder(OrderUpdateDTO orderUpdateDTO) {
        Orders order = Orders.builder().id(orderUpdateDTO.getId())
                .orderNo(orderUpdateDTO.getOrderNo())
                .status(orderUpdateDTO.getStatus())
                .build();
        // 根据条件判断当前订单是否存在
        Integer count = orderMapper.searchOrderByIdAndOrderNo(orderUpdateDTO.getId(),orderUpdateDTO.getOrderNo());
        if(count < 1) {
            log.info("当前订单不存在, id=[{}], orderNo=[{}]",orderUpdateDTO.getId(),orderUpdateDTO.getOrderNo());
            throw new NotFoundException(26003);
        }
        try {
            // 更新订单数据
            orderMapper.updateOrderStatus(order);
        }catch (Exception e) {
            log.error("更新订单数据失败, orderUpdateDTO=[{}]",orderUpdateDTO,e);
            throw new UpdateException(26004);
        }
        if(orderUpdateDTO.getDeliveryNo() != null)  {
            Delivery delivery = Delivery.builder()
                    .deliveryNo(orderUpdateDTO.getDeliveryNo())
                    .orderNo(orderUpdateDTO.getOrderNo())
                    .build();
            try {
                // 为当前订单添加物流信息
                deliveryMapper.insert(delivery);
            }catch (Exception e) {
               log.error("创建物流信息失败, deliveryInfo=[{}]",delivery,e);
               throw new AddException(28001);
            }
        }
    }
}
