package com.elidadindin.Projetodindin.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@Table(schema = "talk", name = "user")
public class UserModel extends BaseModel{

    @Column(name = "first_name", unique = false)
    private String firstName;

    @Column(name = "number", unique = true)
    private String number;
}