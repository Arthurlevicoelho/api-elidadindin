package com.elidadindin.Projetodindin.repositories;

import com.elidadindin.Projetodindin.models.UserAddressID;
import com.elidadindin.Projetodindin.models.UserAddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddressModel, UserAddressID> {
}
