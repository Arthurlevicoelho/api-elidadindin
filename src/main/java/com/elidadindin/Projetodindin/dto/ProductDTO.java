package com.elidadindin.Projetodindin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    @Size(min = 3, max = 30, message = "{validation.name.size}")
    @NotBlank
    private String flavor;

    private Integer availableQuantity;

    @NotNull
    private Double price;

    private byte[] image;

    @Size(min = 3, max = 100, message = "{validation.required.size}")
    private String description;
}
