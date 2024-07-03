package com.elidadindin.Projetodindin.controllers;

import com.elidadindin.Projetodindin.dto.ProductDTO;
import com.elidadindin.Projetodindin.models.ProductModel;
import com.elidadindin.Projetodindin.models.ResponseModel;
import com.elidadindin.Projetodindin.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController extends BaseController<ProductModel, UUID> {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        super(service);
        this.service = service;
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<ResponseModel> post(
                                              @RequestParam("flavor") String flavor,
                                              @RequestParam("availableQuantity") int availableQuantity,
                                              @RequestParam("price") double price,
                                              @RequestParam("description") String description,
                                              @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {

            return service.save(flavor, availableQuantity, price, description, image);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseModel> put(@PathVariable("id") String id,
                                             @RequestParam("flavor") String flavor,
                                             @RequestParam("availableQuantity") int availableQuantity,
                                             @RequestParam("price") double price,
                                             @RequestParam("description") String description,
                                             @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {
        return service.put(id, flavor, availableQuantity, price, description, image);
    }
}