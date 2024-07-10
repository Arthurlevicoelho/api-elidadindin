package com.elidadindin.Projetodindin.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@Table(schema = "talk", name = "user_address")
public class UserAddressModel extends BaseModel{

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @ManyToMany(mappedBy = "address")
    private Set<UserModel> users;
}