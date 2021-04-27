package io.github.talelin.latticy.bo.my;

import io.github.talelin.latticy.dto.my.BelongSpec;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/4/27 10:55
 * @Version 1.0
 * 用于将规格对象转换成json对象时使用
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpecJsonBO {

    private Long key_id;

    private String key;

    private Long value_id;

    private String value;

    public static List<SpecJsonBO> convert(List<BelongSpec> belongSpecs) {
        List<SpecJsonBO> specJsons = new ArrayList<>();
        if(belongSpecs == null || belongSpecs.size() < 1) return specJsons;
        belongSpecs.forEach(belongSpec -> {
            SpecJsonBO specJson = SpecJsonBO.builder()
                    .key_id(belongSpec.getKeyId())
                    .key(belongSpec.getKeyName())
                    .value_id(belongSpec.getValueId())
                    .value(belongSpec.getValueName())
                    .build();
            specJsons.add(specJson);
        });
        return specJsons;
    }
}
