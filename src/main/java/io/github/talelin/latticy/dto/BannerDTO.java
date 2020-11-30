package io.github.talelin.latticy.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class BannerDTO {
    @NotNull
    private String name;

    private String title;

    @NotNull
    private String img;

    @NotNull
    @Length(min = 5)
    private String description;
}
