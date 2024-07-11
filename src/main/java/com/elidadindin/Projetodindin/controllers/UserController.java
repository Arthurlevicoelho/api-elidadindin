package com.elidadindin.Projetodindin.controllers;

import com.elidadindin.Projetodindin.models.AddressModel;
import com.elidadindin.Projetodindin.models.ResponseModel;
import com.elidadindin.Projetodindin.models.UserModel;
import com.elidadindin.Projetodindin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController extends  BaseController<UserModel, UUID> {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        super(service);
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<ResponseModel> post(@RequestBody UserModel user){
        return service.save(user);
    }

    @PostMapping("/address/{userId}")
    public ResponseEntity<ResponseModel> post(@RequestBody AddressModel address, @PathVariable UUID userId){
        return service.saveAddress(address,userId);
    }

    @GetMapping("/address/{userId}")
    public  ResponseEntity<ResponseModel> getAllAddressByUserId(@PathVariable UUID userId){
        return service.getAllAddressByUserId(userId);
    }

}
