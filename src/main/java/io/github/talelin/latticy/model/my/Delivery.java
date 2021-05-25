package io.github.talelin.latticy.model.my;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/24 11:15
 * @Version 1.0
 * 物流信息业务实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Delivery {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 物流单号
     */
    private String deliveryNo;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 发货人
     */
    private String deliveryPerson;
    /**
     * 发货时间
     */
    private Date deliveryTime;
    /**
     * 物流信息详情描述
     */
    private String description;
}
