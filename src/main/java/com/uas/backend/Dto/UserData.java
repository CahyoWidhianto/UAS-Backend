package com.uas.backend.Dto;

public class UserData {
    private String name;
    private String email;
    private String password;
    private String UserRole;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserRole() {
        return UserRole;
    }
    public void setUserRole(String userRole) {
        UserRole = userRole;
    }

    
}
