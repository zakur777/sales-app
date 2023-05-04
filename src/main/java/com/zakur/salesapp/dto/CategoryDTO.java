package com.zakur.salesapp.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private Integer idCategory;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50) //sobre string
    @Max(2) // sobre numeros
    private String nameOfCategory;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 150)
    private String descriptionCategory;

    @NotNull
    private boolean enabledCategory;
}
