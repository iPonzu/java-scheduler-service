    package com.example.demo.domain.ports.out;

public interface PasswordEncoderPort {
    boolean matches(String rawPassword, String encodedPassword);
    String encode(String rawPassword);
}

