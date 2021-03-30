package io.github.talelin.latticy.dto.my;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * @Author Guiquan Chen
 * @Date 2021/3/7 15:53
 * @Version 1.0
 * 更新规格时，使用的DTO
 */
@Data
public class SpecKeyUpdateDTO {
    /**
     * id
     */
    @NotNull
    @Positive
    private Long id;
    /**
     * 规格名
     */
    @NotNull
    @NotEmpty
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
