package com.example.demo.domain.ports.in.auth;

import com.example.demo.application.dto.auth.AuthResult;
import com.example.demo.application.dto.auth.LoginCommand;

public interface LoginUseCase {
    AuthResult execute(LoginCommand command);
}

