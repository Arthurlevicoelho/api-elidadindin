package com.elidadindin.Projetodindin.repositories;

import com.elidadindin.Projetodindin.models.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<AddressModel, UUID> {
}
