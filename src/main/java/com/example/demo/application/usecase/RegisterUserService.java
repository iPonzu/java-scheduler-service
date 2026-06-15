package com.example.demo.application.usecase;

import com.example.demo.application.dto.auth.AuthResult;
import com.example.demo.application.dto.auth.RegisterCommand;
import com.example.demo.domain.enums.Role;
import com.example.demo.domain.model.User;
import com.example.demo.domain.ports.in.auth.RegisterUserUseCase;
import com.example.demo.domain.ports.out.PasswordEncoderPort;
import com.example.demo.domain.ports.out.TokenProviderPort;
import com.example.demo.domain.ports.out.UserRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService implements RegisterUserUseCase {

    private final UserRepositoryPort userRepository;
    private final PasswordEncoderPort passwordEncoder;
    private final TokenProviderPort tokenProvider;

    public RegisterUserService(
        UserRepositoryPort userRepository,
        PasswordEncoderPort passwordEncoder,
        TokenProviderPort tokenProvider
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public AuthResult execute(RegisterCommand command) {

        userRepository.findByEmail(command.email())
            .ifPresent(user -> {
                throw new RuntimeException("Email já cadastrado");
            });

        User user = new User(
            null,
            command.name(),
            command.email(),
            passwordEncoder.encode(command.password()),
            Role.CLIENT
        );

        User savedUser = userRepository.save(user);

        String token = tokenProvider.generateToken(
            savedUser.getId(),
            savedUser.getEmail()
        );

        return new AuthResult(token);
    }
}