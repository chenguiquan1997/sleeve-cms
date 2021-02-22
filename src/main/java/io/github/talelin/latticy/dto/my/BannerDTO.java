package io.github.talelin.latticy.dto.my;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class BannerDTO {
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String img;

    @NotNull
    @Length(min = 5)
    private String description;
}
