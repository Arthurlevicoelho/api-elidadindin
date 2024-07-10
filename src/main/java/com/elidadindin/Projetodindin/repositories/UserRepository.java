package com.elidadindin.Projetodindin.repositories;

import com.elidadindin.Projetodindin.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

    UserModel findByNumber(String number);
}
