package com.example.demo.domain.ports.out;
import  com.example.demo.domain.model.Professional;
import java.util.Optional;

public interface ProfessionalRepositoryPort {
    Optional<Professional> findById(Long id);
}
