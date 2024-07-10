package com.elidadindin.Projetodindin.models;

import com.elidadindin.Projetodindin.enums.OrderStatusEnum;
import com.elidadindin.Projetodindin.enums.PaymentEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@Table(schema = "talk", name = "sales")
public class SalesModel extends BaseModel{

    @OneToOne
    @JoinColumn(name = "id")
    private UserModel user;

    @ManyToMany
    @JoinTable(
            name = "sales_products",
            joinColumns = @JoinColumn(name = "sales_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductModel> products;

    @Column(name = "final_value", nullable = false)
    private Double finalValue;

    @Column(name = "address", nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    private PaymentEnum payment;

    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;
}
