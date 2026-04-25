package com.example.demo.adapters.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.adapters.out.persistence.entity.ServiceJpaEntity;

public interface SpringDataServiceRepository extends JpaRepository<ServiceJpaEntity, Long>{
}
