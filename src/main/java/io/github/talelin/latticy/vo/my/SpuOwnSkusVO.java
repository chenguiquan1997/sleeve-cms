package io.github.talelin.latticy.vo.my;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import io.github.talelin.latticy.model.my.Sku;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/3/16 10:42
 * @Version 1.0
 * 当前spu所拥有的sku
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpuOwnSkusVO {
    /**
     * sku id
     */
    private Long value;
    /**
     * sku 名称
     */
    private String label;

    /**
     * 对象转换
     * @param skuList
     * @return
     */
    public static List<SpuOwnSkusVO> convert(List<Sku> skuList) {
        List<SpuOwnSkusVO> spuOwnSkusVOS = new ArrayList<>();
        if(skuList == null || skuList.size() < 1) return spuOwnSkusVOS;
        skuList.forEach(sku -> {
            SpuOwnSkusVO s = SpuOwnSkusVO.builder().
                    value(sku.getId())
                    .label(sku.getTitle())
                    .build();
            spuOwnSkusVOS.add(s);
        });
        return spuOwnSkusVOS;
    }
}
