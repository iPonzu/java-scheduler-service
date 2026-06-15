package com.example.demo.adapters.in.web.request;

public record LoginRequest(
    String email,
    String password
) {}