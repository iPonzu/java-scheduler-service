package com.example.demo.domain.ports.out;

public interface TokenProviderPort {
    String generateToken(Long userId, String email);
    boolean validateToken(String token);
    String getEmailFromToken(String token);
}
