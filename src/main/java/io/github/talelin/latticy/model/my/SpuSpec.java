package io.github.talelin.latticy.model.my;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Guiquan Chen
 * @Date 2021/4/21 15:02
 * @Version 1.0
 * SPU 对应的 规格
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SpuSpec {
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
}
