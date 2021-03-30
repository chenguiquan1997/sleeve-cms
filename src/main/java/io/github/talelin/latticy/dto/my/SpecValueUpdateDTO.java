package io.github.talelin.latticy.dto.my;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * @Author Guiquan Chen
 * @Date 2021/3/7 16:40
 * @Version 1.0
 * 更新规格值时，用到的DTO
 */
@Data
public class SpecValueUpdateDTO {
    /**
     * id
     */
    private Long id;
    /**
     * 规格值
     */
    @NotNull
    @Length(min = 1)
    private String value;
    /**
     * 规格名id
     */
    @NotNull
    @Positive
    private Long keyId;
    /**
     * 扩展说明
     */
    private String extend;
}
