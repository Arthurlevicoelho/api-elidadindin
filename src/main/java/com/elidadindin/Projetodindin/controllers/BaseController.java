package com.elidadindin.Projetodindin.controllers;

import com.elidadindin.Projetodindin.models.ResponseModel;
import com.elidadindin.Projetodindin.services.BaseService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.UUID;

@RestController
public abstract class BaseController<T, ID extends Serializable> {

    private final BaseService<T, UUID> service;

    public BaseController(BaseService<T, UUID> service) {
        this.service = service;
    }

    @GetMapping(params = { "page", "size" })
    public ResponseEntity<ResponseModel> getAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        return service.getAll(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseModel> get(@PathVariable @NotNull UUID id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseModel> delete(@PathVariable @NotNull UUID id) {
        return service.delete(id);
    }
}
