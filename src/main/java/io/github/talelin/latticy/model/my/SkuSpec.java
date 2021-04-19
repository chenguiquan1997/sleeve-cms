package io.github.talelin.latticy.model.my;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class SkuSpec {

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

}
