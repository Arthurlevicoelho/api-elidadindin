package com.elidadindin.Projetodindin.services;

import com.elidadindin.Projetodindin.models.*;
import com.elidadindin.Projetodindin.repositories.AddressRepository;
import com.elidadindin.Projetodindin.repositories.UserAddressRepository;
import com.elidadindin.Projetodindin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
public class UserService extends BaseService<UserModel, UUID> {

    private final UserRepository userRepository;

    private final AddressRepository addressRepository;

    private final UserAddressRepository userAddressRepository;

    @Autowired
    public UserService(UserRepository userRepository, AddressRepository addressRepository, UserAddressRepository userAddressRepository) {
        super(userRepository);
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.userAddressRepository = userAddressRepository;
    }

    @Transactional
    public ResponseEntity<ResponseModel> save(UserModel user) {
        if (user != null) {
            UserModel u = userRepository.findByNumber(user.getNumber());

            if (u == null) {
                userRepository.save(user);

                return ResponseEntity.ok().body(new ResponseModel(null, "Usuário cadastrado"));
            } else {
                return ResponseEntity.badRequest().body(new ResponseModel(null, "Número já cadastrado"));
            }
        }

        return ResponseEntity.badRequest().body(new ResponseModel(null, "Usuário inválido"));
    }

    @Transactional
    public ResponseEntity<ResponseModel> saveAddress(AddressModel address, UUID userId) {

        if (userId != null) {
            UserModel user = userRepository.findById(userId).get();

            if (address != null) {
                addressRepository.save(address);
                UserAddressModel idSave = new UserAddressModel();

                idSave.setAddressId(address.getId());
                idSave.setAddressModel(address);
                idSave.setUserId(user.getId());
                idSave.setUserModel(user);
                userAddressRepository.save(idSave);
                return ResponseEntity.ok().body(new ResponseModel(null, "Endereço cadastrado"));
            }
        }


        return ResponseEntity.badRequest().body(new ResponseModel(null, "Endereço inválido"));
    }
}