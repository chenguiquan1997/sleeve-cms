package io.github.talelin.latticy.vo.my;

import java.util.Date;
import io.github.talelin.latticy.model.my.SpecKey;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Author Guiquan Chen
 * @Date 2021/3/3 21:10
 * @Version 1.0
 * 规格名VO
 */
@Data
public class SpecKeyVO {
    /**
     * id
     */
    private Long id;
    /**
     * 规格名
     */
    private String name;
    /**
     * 是否为标准规格
     */
    private Boolean standard;
    /**
     * 当前规格的单位，例：个，英寸
     */
    private String unit;
    /**
     * 规格描述
     */
    private String description;
    /**
     * 创建时间
     */
    private Date createTime;

    public SpecKeyVO(SpecKey specKey) {
        BeanUtils.copyProperties(specKey,this);
    }
}
