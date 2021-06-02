package io.github.talelin.latticy.common.enumeration.my;

import java.util.stream.Stream;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/10 16:04
 * @Version 1.0
 * 订单状态枚举
 */
public enum OrderStatusEnum {
    UNPAID(1,"待支付"),
    PAID(2,"已支付"),
    DELIVERED(3,"已发货"),
    FINISHED(4,"已完成"),
    CANCLED(5,"已取消");

    private Integer code;
    private String value;

    OrderStatusEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 根据code码获取指定的订单状态
     * @param code 订单状态码
     * @return
     */
    public static OrderStatusEnum toType(Integer code) {
        return Stream.of(OrderStatusEnum.values())
                .filter(c -> c.code == code)
                .findAny().orElse(null);
    }
}
