package io.github.talelin.latticy.vo.my;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpuOutlineVO<T> {
    /**
     * id
     */
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
    private BigDecimal price;
    /**
     * 商品折扣价
     */
    private BigDecimal discountPrice;
    /**
     * 商品描述
     */
    private String description;
    /**
     * 当前商品所属分类id
     */
    private Long categoryId;
    /**
     * 当前商品所属一级分类id
     */
    private Long rootCategoryId;
    /**
     * 当前商品所属分类名
     */
    private String categoryName;
    /**
     * spu图片
     */
    private String img;
    /**
     * 创建时间
     */
    private Date createTime;
}
