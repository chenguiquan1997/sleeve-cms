package io.github.talelin.latticy.model.my;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.github.talelin.latticy.dto.my.BelongSpec;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/4/13 10:54
 * @Version 1.0
 * 指定sku 所拥有的具体规格
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SkuSpec implements Serializable {

    private static final long serialVersionUID = -8754270499866251255L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * spu id
     */
    private Long spuId;
    /**
     * sku id
     */
    private Long skuId;
    /**
     * 规格名 id
     */
    private Long keyId;
    /**
     * 规格名
     */
    private String keyName;
    /**
     * 规格值 id
     */
    private Long valueId;
    /**
     * 规格值
     */
    private String valueName;

    /**
     * @Description: 向 sku-spec 表添加数据时，用到的数据结构
     * @param belongSpecs 当前 sku 所拥有的规格
     * @param skuId
     * @param spuId
     * @return java.util.List<io.github.talelin.latticy.model.my.SkuSpec>
     * @Author: Guiquan Chen
     * @Date: 2021/5/3
     */
    public static List<SkuSpec> convert(List<BelongSpec> belongSpecs, Long skuId, Long spuId) {
        List<SkuSpec> skuSpecs = new ArrayList<>();
        if(belongSpecs.size() < 1 || belongSpecs == null) return skuSpecs;
        belongSpecs.forEach(belongSpec -> {
            SkuSpec skuSpec = SkuSpec.builder()
                    .spuId(spuId)
                    .skuId(skuId)
                    .keyId(belongSpec.getKeyId())
                    .valueId(belongSpec.getValueId())
                    .build();
            skuSpecs.add(skuSpec);
        });
        return skuSpecs;
    }

}
