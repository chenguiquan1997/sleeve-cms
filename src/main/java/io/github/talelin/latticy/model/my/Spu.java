package io.github.talelin.latticy.model.my;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Spu实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Spu extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1237508768079137785L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品副标题
     */
    private String subtitle;
    /**
     * 当前商品是否上架
     */
    private Boolean online;
    /**
     * 商品价格
     */
    private String price;
    /**
     * 可视化规格id
     */
    private Integer sketchSpecId;
    /**
     * 当前商品默认展示的sku, id值
     */
    private Integer defaultSkuId;
    /**
     * 商品折扣价
     */
    private String discountPrice;
    /**
     * 商品描述
     */
    private String description;
    /**
     * 商品图片
     */
    private String img;
    /**
     *
     */
    private Boolean isBest;
    /**
     * 商品主题图片
     */
    private String spuThemeImg;
    /**
     * 可以不用
     */
    private String forThemeImg;
    /**
     * 当前商品所属分类id
     */
    private Integer categoryId;
    /**
     * 当前商品所属一级分类id
     */
    private Integer rootCategoryId;
    /**
     * 商品标签
     */
    private String tags;
}
