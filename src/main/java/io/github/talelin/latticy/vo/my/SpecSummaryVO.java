package io.github.talelin.latticy.vo.my;

import lombok.Data;
import io.github.talelin.latticy.model.my.SpecKey;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/3/10 17:39
 * @Version 1.0
 */
@Data
public class SpecSummaryVO {

    private Long id;

    private String name;

    public static List<SpecSummaryVO> convert(List<SpecKey> specKeyList) {
        List<SpecSummaryVO> specSummaryVOS = new ArrayList<>();
        if(specKeyList == null || specKeyList.size() < 1) return specSummaryVOS;
        specKeyList.forEach(specKey -> {
            SpecSummaryVO specSummaryVO = new SpecSummaryVO();
            BeanUtils.copyProperties(specKey,specSummaryVO);
            specSummaryVOS.add(specSummaryVO);
        });
        return specSummaryVOS;
    }
}
