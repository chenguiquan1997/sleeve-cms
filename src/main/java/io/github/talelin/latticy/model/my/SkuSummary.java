package io.github.talelin.latticy.model.my;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author Guiquan Chen
 * @Date 2021/3/30 17:14
 * @Version 1.0
 * 存储Sku概要业务实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkuSummary {
    /**
     * id
     */
    private Long id;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 折扣价
     */
    private BigDecimal discountPrice;
    /**
     * 是否上架
     */
    private Boolean online;
    /**
     * 图片
     */
    private String img;
    /**
     * 标题
     */
    private String title;
    /**
     * spu id
     */
    private Long spuId;
    /**
     * 所属 spu
     */
    private String belongSpu;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 创建时间
     */
    private Date createTime;
}
