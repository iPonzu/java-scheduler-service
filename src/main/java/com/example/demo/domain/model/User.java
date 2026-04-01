package com.example.demo.domain.model;
import com.example.demo.domain.enums.Role;

public class User{
    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;


    public User(Long id, String name, String email, String password, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
    
    public boolean isAdmin() {
        return Role.ADMIN.equals(this.role);
    }
    public Boolean isClient() {
        return Role.CLIENT.equals(this.role);
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public Role getRole() {
        return role;
    }

}

