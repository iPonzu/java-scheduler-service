package com.example.demo.domain.ports.out;
import com.example.demo.domain.model.ServiceItem;
import java.util.Optional;

public interface ServiceRepositoryPort {
    Optional<ServiceItem> findById(Long id);
}
