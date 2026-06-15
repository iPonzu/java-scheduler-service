package com.example.demo.adapters.out.persistence.entity;

import com.example.demo.domain.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;    
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    public UserJpaEntity() {}

    public UserJpaEntity(
        Long userId, 
        String name, 
        String email, 
        String password, 
        Role role
    ){
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getUserId() {  return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public Role getRole() { return role; }

    public void setUserId(Long id) {this.userId = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) {this.email = email; }
    public void setPassword(String password) {this.password = password; }
    
    // Métodos úteis para verificar role
    public boolean isAdmin() { return Role.ADMIN.equals(this.role); }
    public boolean isClient() { return Role.CLIENT.equals(this.role); }
}
