package io.github.talelin.latticy.vo.my;

import io.github.talelin.latticy.model.my.SpecKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/3/16 19:11
 * @Version 1.0
 * 用于cms中编辑可视化规格
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpecSketchVO {
    /**
     * 规格 id
     */
    private Long value;
    /**
     * 规格名
     */
    private String label;

    /**
     * 对象之间的转换
     * @param specKeys
     * @return
     */
    public static List<SpecSketchVO> convert(List<SpecKey> specKeys) {
        List<SpecSketchVO> specSketchVOS = new ArrayList<>();
        if(specKeys == null || specKeys.size() < 1) return specSketchVOS;
        specKeys.forEach(specKey -> {
            SpecSketchVO specSketchVO = SpecSketchVO.builder()
                    .value(specKey.getId())
                    .label(specKey.getName())
                    .build();
            specSketchVOS.add(specSketchVO);
        });
        return specSketchVOS;
    }
}
