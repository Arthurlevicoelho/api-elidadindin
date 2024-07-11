package com.elidadindin.Projetodindin.repositories;

import com.elidadindin.Projetodindin.models.UserAddressID;
import com.elidadindin.Projetodindin.models.UserAddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserAddressRepository extends JpaRepository<UserAddressModel, UserAddressID> {

    List<UserAddressModel> findByUserId(UUID userId);
}
