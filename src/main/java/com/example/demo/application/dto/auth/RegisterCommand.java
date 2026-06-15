package com.example.demo.application.dto.auth;

public record RegisterCommand(
    String name,
    String email, 
    String password
) {}