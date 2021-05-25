package io.github.talelin.latticy.mapper.my;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.bo.my.ConditionSearchBO;
import io.github.talelin.latticy.model.my.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/5 16:36
 * @Version 1.0
 */
@Repository
public interface OrderMapper extends BaseMapper<Orders> {
    /**
     * 分页获取订单列表数据
     * @param startCount
     * @param size
     * @return
     */
    List<Orders> searchOrderListByPage(@Param("startCount") Integer startCount,
                                       @Param("size") Integer size,
                                       @Param("conditions") ConditionSearchBO conditions);

    /**
     * 根据查询条件，获取符合条件的订单总数量
     * @param conditions
     * @return
     */
    Integer getOrderTotalCount(@Param("conditions") ConditionSearchBO conditions);

    /**
     * 根据 id 和 订单号，查询唯一的一条订单数据是否存在
     * @param id
     * @param orderNo
     * @return
     */
    Integer searchOrderByIdAndOrderNo(@Param("id") Long id, @Param("orderNo") String orderNo);

    /**
     * 根据 id 和 订单号，更新唯一的一条订单数据
     * @param order 订单实体类
     */
    void updateOrderStatus(@Param("order") Orders order);

}
