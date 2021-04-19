package io.github.talelin.latticy.vo.my;

import io.github.talelin.latticy.model.my.SpecValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/3/8 10:44
 * @Version 1.0
 * 规格值视图类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpecValueVO {
    /**
     * id
     */
    private Long id;
    /**
     * 规格值
     */
    private String value;
    /**
     * 规格名id
     */
    private Long keyId;
    /**
     * 扩展说明
     */
    private String extend;

    public SpecValueVO(SpecValue specValue) {
        BeanUtils.copyProperties(specValue,this);
    }

    /**
     * 类型转换
     * @param specValues
     * @return
     */
    public static List<SpecValueVO> convert(List<SpecValue> specValues) {
        List<SpecValueVO> specValueVOS = new ArrayList<>();
        if(specValues == null || specValues.size() < 1) return null;
        specValues.forEach(specValue -> {
            SpecValueVO specValueVO = SpecValueVO.builder()
                    .id(specValue.getId())
                    .value(specValue.getValue())
                    .build();
            specValueVOS.add(specValueVO);
        });
        return specValueVOS;
    }
}
