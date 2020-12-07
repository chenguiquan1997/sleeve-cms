package io.github.talelin.latticy.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class SpecValueDTO {

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
}
