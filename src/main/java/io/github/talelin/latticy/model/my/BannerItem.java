package io.github.talelin.latticy.model.my;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.github.talelin.latticy.common.enumeration.my.BannerItemTypeEnum;
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

    @TableId(value = "id", type = IdType.AUTO)
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
    private Integer type;
    /**
     * 当前bannerItem的类型名称
     */
    private String typeName;
    /**
     * item名称
     */
    private String name;
    /**
     * 关联banner表的外键
     */
    private Long bannerId;

    /**
     * 根据typeName 获取type值
     * @return
     */
    public Integer getTypeByTypeName(String typeName) {
        Integer type = BannerItemTypeEnum.getValue(typeName).getCode();
        return type;
    }
}
