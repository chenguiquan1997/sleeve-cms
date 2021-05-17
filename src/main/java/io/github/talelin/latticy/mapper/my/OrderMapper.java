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

    Integer getOrderTotalCount(@Param("conditions") ConditionSearchBO conditions);

}
