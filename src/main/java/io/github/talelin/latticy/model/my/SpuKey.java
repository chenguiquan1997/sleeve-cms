package io.github.talelin.latticy.model.my;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/3/23 19:11
 * @Version 1.0
 * SPU - 规格 两者的主键 id 关联表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpuKey {

    private Long id;

    private Long spuId;

    private Long specKeyId;

    public static List<SpuKey> construct(List<Long> specs, Long spuId) {
        if(specs == null || specs.size() < 1) return null;
        List<SpuKey> spuKeys = new ArrayList<>();
        specs.forEach(spec -> {
            SpuKey spuKey = SpuKey.builder()
                    .specKeyId(spec)
                    .spuId(spuId)
                    .build();
            spuKeys.add(spuKey);
        });
        return spuKeys;
    }
}
