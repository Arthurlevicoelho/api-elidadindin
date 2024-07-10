package com.elidadindin.Projetodindin.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@Table(schema = "talk", name = "product")
public class ProductModel extends BaseModel{

    @Size(min = 3, max = 30, message = "{validation.name.size}")
    @NotBlank
    @Column(name = "flavor", unique = true)
    private String flavor;

    @Column(name = "available_quantity")
    private Integer availableQuantity;

    @NotNull
    private Double price;

    @Column(columnDefinition = "BYTEA")
    private byte[] image;

    @Size(min = 3, max = 100, message = "{validation.required.size}")
    private String description;
}
