package com.example.catalogo.Model.Usuario;

public enum UserRoles {
    ADMIN("admin"), USER("user");

    private String role;
    UserRoles(String role){
        this.role = role;
    }

    public String GetRole(){
        return this.role;
    }
}
