package com.example.demo.adapters.out.persistence.adapter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.adapters.out.persistence.entity.UserJpaEntity;
import com.example.demo.adapters.out.persistence.repository.SpringDataUserRepository;
import com.example.demo.domain.model.User;
import com.example.demo.domain.ports.out.UserRepositoryPort;

@Component
public class UserPersistenceAdapter implements UserRepositoryPort {
    private final SpringDataUserRepository repository;

    public UserPersistenceAdapter(SpringDataUserRepository repository){
        this.repository = repository;
    }

    @Override
    public Optional<User> findById(Long id){
        return repository.findById(id)
            .map(this::toDomain);
    }
    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email)
            .map(this::toDomain);
}
    @Override
    public User save(User user){
        return this.toDomain(repository.save(this.toEntity(user)));
    }
    private User toDomain(UserJpaEntity entity){
        return new User(
            entity.getUserId(),
            entity.getName(),
            entity.getEmail(),
            entity.getPassword(),
            entity.getRole()
        );
    }

    private UserJpaEntity toEntity(User user){
        return new UserJpaEntity(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getPassword(),
            user.getRole()
        );
    }
}