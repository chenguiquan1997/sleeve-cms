package io.github.talelin.latticy.vo.my;

import io.github.talelin.latticy.model.my.SpecValue;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Author Guiquan Chen
 * @Date 2021/3/8 10:44
 * @Version 1.0
 * 规格值视图类
 */
@Data
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
}
