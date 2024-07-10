package com.elidadindin.Projetodindin.services;

import com.elidadindin.Projetodindin.models.ProductModel;
import com.elidadindin.Projetodindin.models.ResponseModel;
import com.elidadindin.Projetodindin.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.UUID;

@Component
public class ProductService extends BaseService<ProductModel, UUID>{

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        super(repository);

        this.repository = repository;
    }

    public ResponseEntity<ResponseModel> getByFlavor(String flavor){

        if(flavor != null){
            ProductModel productModel = repository.findByFlavor(flavor);

            if (productModel != null){
                return ResponseEntity.ok().body(new ResponseModel(repository.findByFlavor(flavor),""));
            }else {
                return ResponseEntity.badRequest().body(new ResponseModel(null,"O sabor não existe"));
            }
        }
        return ResponseEntity.badRequest().body(new ResponseModel(null,"Produto inválido"));
    }
    @Transactional
    public ResponseEntity<ResponseModel> save(String flavor,int availableQuantity, double price, String description, MultipartFile image) throws IOException {

        ProductModel productModel = new ProductModel();
        productModel.setFlavor(flavor);
        productModel.setAvailableQuantity(availableQuantity);
        productModel.setPrice(price);
        productModel.setDescription(description);
        if( image == null){
            return ResponseEntity.badRequest().body(new ResponseModel(null, "Imagem obrigatoria"));

        }
        if (!image.isEmpty()) {
            try {
                byte[] imageBytes = image.getBytes();
                productModel.setImage(imageBytes);
            } catch (IOException | NullPointerException e) {
                return ResponseEntity.badRequest().body(new ResponseModel(null, "Imagem errada"));
            }
        }


        if(productModel != null){
            ProductModel product = repository.findByFlavor(productModel.getFlavor());

            if(product == null){
                repository.save(productModel);

                return ResponseEntity.ok().body(new ResponseModel(null,"Produto cadastrado com sucesso!"));
            }else {
                return ResponseEntity.badRequest().body(new ResponseModel(null,"Sabor já cadastrado"));
            }
        }

        return ResponseEntity.badRequest().body(new ResponseModel(null,"Produto inválido"));
    }

    public ResponseEntity<ResponseModel> put(String id, String flavor, int availableQuantity, double price, String description, MultipartFile image) throws IOException {
        UUID productId;
        try {
            productId = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ResponseModel(null, "deu pau no back"));
        }

        ProductModel productUpdate = repository.findById(productId).orElse(null);

        if (productUpdate == null) {
            return ResponseEntity.badRequest().body(new ResponseModel(null, "Produto não encontrado"));
        }

        ProductModel existingProductWithFlavor = repository.findByFlavor(flavor);

        if (existingProductWithFlavor != null && !existingProductWithFlavor.equals(productUpdate)) {
            return ResponseEntity.badRequest().body(new ResponseModel(null, "Nome do produto já utilizado"));
        }

        productUpdate.setFlavor(flavor);
        productUpdate.setDescription(description);
        productUpdate.setPrice(price);
        productUpdate.setAvailableQuantity(availableQuantity);

        if (image != null && !image.isEmpty()) {
            productUpdate.setImage(image.getBytes());
        }

        repository.save(productUpdate);
        return ResponseEntity.ok().body(new ResponseModel(productUpdate, "Produto atualizado com sucesso!"));
    }
}
