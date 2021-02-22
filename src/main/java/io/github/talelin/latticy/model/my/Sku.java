package io.github.talelin.latticy.model.my;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sku extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -961548821210744521L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
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
     * 副标题
     */
    private Long spuId;
    /**
     * sku 规格
     */
    private String specs;
    /**
     * 当前sku 唯一识别码
     */
    private String code;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 所属父级分类
     */
    private Long categoryId;
    /**
     * 所属一级分类
     */
    private Long rootCategoryId;
}
