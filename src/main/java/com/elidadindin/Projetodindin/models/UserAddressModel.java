package com.elidadindin.Projetodindin.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "talk", name = "user_address")
@IdClass(UserAddressID.class)
public class UserAddressModel {

    @Id
    @Column(name = "user_id")
    UUID userId;

    @Id
    @Column(name = "address_id")
    UUID addressId;

    @ManyToOne
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserModel userModel;

    @ManyToOne
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    private AddressModel addressModel;
}
