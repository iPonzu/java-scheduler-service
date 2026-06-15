package com.example.demo.adapters.in.web.request;

public record RegisterRequest(
    String name,
    String email,
    String password
) {}
