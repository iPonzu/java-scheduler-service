package com.example.demo.domain.ports.out;

import java.util.Optional;

import com.example.demo.domain.model.User;

public interface UserRepositoryPort {

    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);

    User save(User user);
}