package io.github.talelin.latticy.mapper.my;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.my.Delivery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/24 14:48
 * @Version 1.0
 * 物流信息
 */
@Repository
public interface DeliveryMapper extends BaseMapper<Delivery> {

    /**
     * 根据订单号查询对应的物流单号
     * @param orderNo
     * @return
     */
    String searchDeliveryNoByOrderNo(@Param("orderNo") String orderNo);
}
