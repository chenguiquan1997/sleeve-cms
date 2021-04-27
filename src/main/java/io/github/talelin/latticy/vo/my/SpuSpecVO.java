package io.github.talelin.latticy.vo.my;

import io.github.talelin.latticy.model.my.SpuSpec;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/4/21 16:43
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SpuSpecVO {
    /**
     * spu id
     */
    private Long spuId;
    /**
     * 规格 id
     */
    private Long keyId;
    /**
     * 规格名
     */
    private String keyName;

    public static List<SpuSpecVO> convert(List<SpuSpec> spuSpecs) {
        if(spuSpecs == null || spuSpecs.size() < 1) return null;
        List<SpuSpecVO> spuSpecsList = new ArrayList<>();
        spuSpecs.forEach(spuSpec -> {
            SpuSpecVO spuSpec1 = SpuSpecVO.builder()
                                .spuId(spuSpec.getSpuId())
                                .keyId(spuSpec.getKeyId())
                                .keyName(spuSpec.getKeyName())
                                .build();
            spuSpecsList.add(spuSpec1);
        });
        return spuSpecsList;
    }
}
