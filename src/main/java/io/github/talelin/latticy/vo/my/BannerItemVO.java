package io.github.talelin.latticy.vo.my;

import io.github.talelin.latticy.model.my.BannerItem;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
public class BannerItemVO {

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
     * 创建时间
     */
    private Date createTime;

    public BannerItemVO(BannerItem bannerItem) {
        BeanUtils.copyProperties(bannerItem,this);
    }
}
