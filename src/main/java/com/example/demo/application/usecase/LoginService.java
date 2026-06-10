package com.example.demo.application.usecase;

import com.example.demo.application.dto.auth.AuthResult;
import com.example.demo.application.dto.auth.LoginCommand;
import com.example.demo.domain.ports.out.PasswordEncoderPort;
import com.example.demo.domain.ports.out.TokenProviderPort;
import com.example.demo.domain.ports.out.UserRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginUseCase {
    private final UserRepositoryPort userRepository;
    private final PasswordEncoderPort passwordEncoder;
    private final TokenProviderPort tokenProvider;

    public LoginService(
        UserRepositoryPort userRepository,
        PasswordEncoderPort passwordEncoder,
        TokenProviderPort tokenProvider
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public AuthResult execute(LoginCommand command){
        var user = userRepository.findByEmail(command.email())
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if(!passwordEncoder.matches(command.password(), user.getPassword())){
            throw new RuntimeException("Senha incorreta");
        }
        String token = tokenProvider.generateToken(user.getEmail());
        return new AuthResult(token);
    }
}
