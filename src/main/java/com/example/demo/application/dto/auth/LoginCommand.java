package com.example.demo.application.dto.auth;

public record LoginCommand(
        String email,
        String password
) {}