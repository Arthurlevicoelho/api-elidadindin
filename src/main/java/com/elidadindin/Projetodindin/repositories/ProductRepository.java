package com.elidadindin.Projetodindin.repositories;

import com.elidadindin.Projetodindin.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductModel, UUID> {

    ProductModel findByFlavor(String flavor);
}
