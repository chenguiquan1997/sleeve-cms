package io.github.talelin.latticy.bo.my;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/5 17:29
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressBO {
    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 区
     */
    private String county;
    /**
     * 详细地址
     */
    private String detail;
    /**
     * 收货人
     */
    private String userName;
    /**
     * 联系方式
     */
    private String mobile;
    /**
     *
     */
    private String nationalCode;
    /**
     * 邮政编码
     */
    private String postalCode;
}
