package io.github.talelin.latticy.vo.my;

import io.github.talelin.latticy.bo.my.SkuBO;
import io.github.talelin.latticy.model.my.SkuSpec;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/4/13 11:38
 * @Version 1.0
 * sku 详情VO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SkuDetailVO {
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
     * 所属SPU id
     */
    private Long spuId;
    /**
     * 所属SPU 名称
     */
    private String belongSpu;
    /**
     * sku 拥有的规格
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
     * 当前sku所拥有的规格
     */
    private List<SkuSpec> skuSpecs;

    public static SkuDetailVO convert(SkuBO skuBO) {
        SkuDetailVO skuDetailVO = new SkuDetailVO();
        if(skuBO == null) return skuDetailVO;
        BeanUtils.copyProperties(skuBO,skuDetailVO);
        skuDetailVO.setSkuSpecs(skuDetailVO.integration(skuDetailVO.getSkuSpecs()));
        return skuDetailVO;
    }

    /**
     * @Description: 将规格值id和规格值整合到一起
     * @param skuSpecs 当前sku所拥有的规格
     * @return java.util.List<io.github.talelin.latticy.model.my.SkuSpec>
     * @Author: Guiquan Chen
     * @Date: 2021/4/20
     */
    private List<SkuSpec> integration(List<SkuSpec> skuSpecs) {
        if(skuSpecs == null || skuSpecs.size() < 1) return null;
        skuSpecs.forEach(spec -> {
            StringBuffer buffer = new StringBuffer();
            Long valueId = spec.getValueId();
            String valueName = spec.getValueName();
            buffer.append(valueId.toString()).append(" - ").append(valueName);
            spec.setValueName(buffer.toString());
        });
        return skuSpecs;
    }
}
