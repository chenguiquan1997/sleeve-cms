package io.github.talelin.latticy.model.my;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.github.talelin.latticy.dto.my.SpuSaveDTO;
import io.github.talelin.latticy.dto.my.SpuUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Spu实体类
 */
@Data
@Builder
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
    private BigDecimal price;
    /**
     * 可视化规格id
     */
    private Long sketchSpecId;
    /**
     * 当前商品默认展示的sku, id值
     */
    private Long defaultSkuId;
    /**
     * 商品折扣价
     */
    private BigDecimal discountPrice;
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
    private Long categoryId;
    /**
     * 当前商品所属一级分类id
     */
    private Long rootCategoryId;
    /**
     * 商品标签
     */
    private String tags;

    /**
     * @Description: 将 spuUpdateDTO 中的一部分内容，转化为 SPU
     * @param spuUpdateDTO
     * @return io.github.talelin.latticy.model.my.Spu
     * @Author: Guiquan Chen
     * @Date: 2021/3/23
     */
    public static Spu convert(SpuUpdateDTO spuUpdateDTO) {
        Spu spu = Spu.builder()
                .id(spuUpdateDTO.getId())
                .title(spuUpdateDTO.getTitle())
                .subtitle(spuUpdateDTO.getSubtitle())
                .online(spuUpdateDTO.isOnline())
                .price(spuUpdateDTO.getPrice())
                .discountPrice(spuUpdateDTO.getDiscountPrice())
                .rootCategoryId(spuUpdateDTO.getRootCategoryId())
                .categoryId(spuUpdateDTO.getParentCategoryId())
                .sketchSpecId(spuUpdateDTO.getSketchSpecId())
                .defaultSkuId(spuUpdateDTO.getDefaultSkuId())
                .description(spuUpdateDTO.getDescription())
                .spuThemeImg(spuUpdateDTO.getThemeImgData())
                .img(spuUpdateDTO.getMainImgData())
                .build();
        // 拆解 spu 标签
        List<String> tags = spuUpdateDTO.getTagList();
        String tag1;
        splitTags(spu, tags);
        return spu;
    }

    /**
     * @Description: 将 spuSaveDTO 中的一部分内容，转化为 SPU
     * @param spuSaveDTO
     * @return io.github.talelin.latticy.model.my.Spu
     * @Author: Guiquan Chen
     * @Date: 2021/3/29
     */
    public static Spu convert(SpuSaveDTO spuSaveDTO) {
        Spu spu = Spu.builder()
                .title(spuSaveDTO.getTitle())
                .subtitle(spuSaveDTO.getSubtitle())
                .online(spuSaveDTO.isOnline())
                .price(spuSaveDTO.getPrice())
                .discountPrice(spuSaveDTO.getDiscountPrice())
                .rootCategoryId(spuSaveDTO.getRootCategoryId())
                .categoryId(spuSaveDTO.getParentCategoryId())
                .sketchSpecId(spuSaveDTO.getSketchSpecId())
                .description(spuSaveDTO.getDescription())
                .spuThemeImg(spuSaveDTO.getThemeImgData())
                .img(spuSaveDTO.getMainImgData())
                .build();
        // 拆解 spu 标签
        List<String> tags = spuSaveDTO.getTagList();
        String tag1;
        splitTags(spu, tags);
        return spu;
    }

    /**
     * @Description:
     * @param spu
     * @param tags
     * @Author: Guiquan Chen
     * @Date: 2021/3/29
     */
    private static void splitTags(Spu spu, List<String> tags) {
        String tag1;
        if(tags != null && tags.size() > 0) {
            StringBuffer tagBuffer = new StringBuffer("");
            tags.forEach(tag -> {
                tagBuffer.append(tag).append("$");
            });
            tag1 = tagBuffer.substring(0,tagBuffer.length()-1);
            spu.setTags(tag1);
        }
    }
}
