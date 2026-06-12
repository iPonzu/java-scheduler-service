package com.example.demo.adapters.out.persistence.adapter;
import com.example.demo.domain.ports.out.ProfessionalRepositoryPort;
import com.example.demo.adapters.out.persistence.entity.ProfessionalJpaEntity;
import com.example.demo.adapters.out.persistence.repository.SpringDataProfessionalRepository;
import com.example.demo.domain.model.Professional;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class ProfessionalPersistenceAdapter implements ProfessionalRepositoryPort {
    
    private final SpringDataProfessionalRepository repository;

    public ProfessionalPersistenceAdapter(SpringDataProfessionalRepository repository){
        this.repository = repository;
    }

    @Override
    public Optional<Professional> findById(Long id){
        return repository.findById(id)
            .map(this::toDomain);
    }
    private Professional toDomain(ProfessionalJpaEntity entity){
        return new Professional(
            entity.getId(),
            entity.getName(),
            entity.getSpeciality()
        );
    }   
    private ProfessionalJpaEntity toEntity(Professional professional){
        return new ProfessionalJpaEntity(
            professional.getId(),
            professional.getName(),
            professional.getSpeciality()
        );
    }

}
