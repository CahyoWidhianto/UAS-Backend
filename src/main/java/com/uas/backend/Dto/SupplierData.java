package com.uas.backend.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class SupplierData {
    

    @NotEmpty(message = "name is required")
    private String name;
    @NotEmpty(message = "address is required")
    private String alamat;
    @NotEmpty(message = "email is required")
    @Email(message = "email is not vailed")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
