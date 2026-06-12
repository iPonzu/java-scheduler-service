package com.example.demo.adapters.out.security.adapter;
import org.springframework.stereotype.Component;
import com.example.demo.adapters.out.security.jwt.JwtTokenProvider;
import com.example.demo.domain.ports.out.TokenProviderPort;

@Component
public class TokenProviderAdapter implements TokenProviderPort {
    private final JwtTokenProvider jwtTokenProvider;

    public TokenProviderAdapter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String generateToken(Long userId, String email){
        return jwtTokenProvider.generateToken(userId, email);
    }
    
    @Override
    public boolean validateToken(String token){
        return jwtTokenProvider.validateToken(token);
    }

    @Override
    public String getEmailFromToken(String token){
        return jwtTokenProvider.getEmailFromToken(token);
    }
}