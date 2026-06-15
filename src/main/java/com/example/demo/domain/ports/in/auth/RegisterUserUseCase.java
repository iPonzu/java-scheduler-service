package com.example.demo.domain.ports.in.auth;
import com.example.demo.application.dto.auth.AuthResult;
import com.example.demo.application.dto.auth.RegisterCommand;

public interface RegisterUserUseCase {
    AuthResult execute(RegisterCommand command);
}
