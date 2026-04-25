package com.example.demo.adapters.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.adapters.out.persistence.entity.ProfessionalJpaEntity;

public interface SpringDataProfessionalRepository extends JpaRepository<ProfessionalJpaEntity, Long>{
    
}
