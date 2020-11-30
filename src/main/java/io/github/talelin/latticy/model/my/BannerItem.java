package io.github.talelin.latticy.model.my;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @EqualsAndHashCode(callSuper = true) 注解的作用就是将其父类属性也进行比较
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BannerItem extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -2058694798483785444L;

    private Long id;
    /**
     * 图片地址
     */
    private String img;
    /**
     * 当前banner_item的唯一业务标识
     */
    private String keyword;
    /**
     * item类型，一共三种
     */
    private Short type;
    /**
     * item名称
     */
    private String name;
    /**
     * 关联banner表的外键
     */
    private Long bannerId;
}
