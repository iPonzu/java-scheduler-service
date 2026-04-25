package com.example.demo.adapters.out.persistence.adapter;

import com.example.demo.adapters.out.persistence.entity.ServiceJpaEntity;
import com.example.demo.adapters.out.persistence.repository.SpringDataServiceRepository;
import com.example.demo.domain.model.ServiceItem;
import com.example.demo.domain.ports.out.ServiceRepositoryPort;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class ServicePersistenceAdapter implements ServiceRepositoryPort {
    private final SpringDataServiceRepository repository;

    public ServicePersistenceAdapter(SpringDataServiceRepository repository){
        this.repository = repository;
    }
    
    @Override
    public Optional<ServiceItem> findById(Long id){
        return repository.findById(id)
        .map(this::toDomain);
    }
    private ServiceItem toDomain(ServiceJpaEntity entity){
        return new ServiceItem(
            entity.getId(),
            entity.getName(),
            entity.getDescription(),
            entity.getDurationInMinutes(),
            entity.getPrice()
        );
    }
    private ServiceJpaEntity toEntity(ServiceItem service){
        return new ServiceJpaEntity(
            service.getId(),
            service.getName(),
            service.getDescription(),
            service.getDurationInMinutes(),
            service.getPrice()
        );
    }
}
