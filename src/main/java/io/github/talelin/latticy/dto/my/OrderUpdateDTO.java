package io.github.talelin.latticy.dto.my;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/24 11:02
 * @Version 1.0
 * 用于订单修改业务的参数接收类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderUpdateDTO {
    /**
     * id
     */
    @NotNull
    @Positive
    private Long id;
    /**
     * 订单号
     */
    @NotEmpty
    private String orderNo;
    /**
     * 订单状态
     */
    @NotNull
    private Integer status;
    /**
     * 物流单号
     */
    private String deliveryNo;
}
