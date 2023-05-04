package com.zakur.salesapp.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer idProduct;

    @NotNull
    private Integer idCategory;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nameProduct;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 150)
    private String descriptionProduct;

    @Min(value = 1)
    @Max(value = 9999)
    private Integer priceProduct;

    @NotNull
    private boolean enabledProduct;
}
