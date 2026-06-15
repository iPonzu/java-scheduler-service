package com.example.demo.adapters.in.web.controller;
import com.example.demo.adapters.in.web.request.LoginRequest;
import com.example.demo.adapters.in.web.request.RegisterRequest;
import com.example.demo.application.dto.auth.LoginCommand;
import com.example.demo.application.dto.auth.RegisterCommand;
import com.example.demo.domain.ports.in.auth.LoginUseCase;
import com.example.demo.domain.ports.in.auth.RegisterUserUseCase;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {
    private final RegisterUserUseCase registerUserUseCase;
    private final LoginUseCase loginUseCase;

    public AuthController(
        RegisterUserUseCase registerUserUseCase,
        LoginUseCase loginUseCase
    ){
        this.registerUserUseCase = registerUserUseCase;
        this.loginUseCase = loginUseCase;
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(
            registerUserUseCase.execute(new RegisterCommand(
                request.name(),
                request.email(),
                request.password()
            ))
        );
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(
            loginUseCase.execute(new LoginCommand(
                request.email(),
                request.password()
            ))
        );
    }
    

}
