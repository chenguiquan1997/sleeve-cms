package io.github.talelin.latticy.dto.my;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class SpecKeyDTO {

    /**
     * 规格名
     */
    @NotNull
    @Length(min = 1)
    private String name;
    /**
     * 是否为标准规格
     */
    @NotNull
    private Boolean standard;
    /**
     * 当前规格的单位，例：个，英寸
     */
    private String unit;
    /**
     * 规格描述
     */
    private String description;
}
