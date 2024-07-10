package com.elidadindin.Projetodindin.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(schema = "talk", name = "sales_products")
public class SalesProductsModel {

    @Id
    @ManyToOne
    @JoinColumn(name = "sales_id", nullable = false)
    private SalesModel sales;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductModel product;
}
