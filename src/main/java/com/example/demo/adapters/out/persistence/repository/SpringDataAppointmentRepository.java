package com.example.demo.adapters.out.persistence.repository;

import com.example.demo.adapters.out.persistence.entity.AppointmentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface SpringDataAppointmentRepository extends JpaRepository<AppointmentJpaEntity, Long> {
    boolean existsByProfessionalIdAndAppointmentDate(Long professionalId, LocalDateTime appointmentDate);
}
