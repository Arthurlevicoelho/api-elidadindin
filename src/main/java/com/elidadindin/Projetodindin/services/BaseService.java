package com.elidadindin.Projetodindin.services;

import com.elidadindin.Projetodindin.models.ResponseModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;

public abstract class BaseService <T, ID extends Serializable> {

    private final JpaRepository<T, UUID> repository;

    protected BaseService(JpaRepository<T, UUID> repository) {
        this.repository = repository;
    }

    public ResponseEntity<ResponseModel> getAll(int page, int size) {
        return ResponseEntity.ok().body(new ResponseModel(repository.findAll(PageRequest.of(page, size)), ""));
    }

    public ResponseEntity<ResponseModel> get(UUID id) {
        if (id == null) return ResponseEntity.badRequest().body(new ResponseModel(null, "Id não enviado"));

        return ResponseEntity.ok().body(new ResponseModel(repository.findById(id).get(), ""));
    };

    public ResponseEntity<ResponseModel> delete(UUID id) {
        if (id == null) return ResponseEntity.badRequest().body(new ResponseModel(null, "Id não enviado"));

        repository.deleteById(id);

        return ResponseEntity.ok().body(new ResponseModel(null, "Removido com sucesso"));
    };

}
