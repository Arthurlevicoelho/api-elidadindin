package com.elidadindin.Projetodindin.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class UserAddressID implements Serializable {

    private UUID userId;

    private UUID addressId;

    public UserAddressID(){}

    public UserAddressID(UUID userId, UUID addressId) {
        this.userId = userId;
        this.addressId = addressId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getAddressId() {
        return addressId;
    }

    public void setAddressId(UUID addressId) {
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAddressID that = (UserAddressID) o;
        return Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getAddressId(), that.getAddressId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getAddressId());
    }
}
