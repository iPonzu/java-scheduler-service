package com.example.demo.adapters.out.persistence.entity;

import java.time.LocalDateTime;

import com.example.demo.domain.enums.AppointmentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "agendamentos")
public class AppointmentJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "professional_id", nullable = false)
    private Long professionalId;

    @Column(name = "service_id", nullable = false)
    private Long serviceId;

    @Column(name = "appointment_date", nullable = false)
    private LocalDateTime appointmentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AppointmentStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public AppointmentJpaEntity() {}

    public AppointmentJpaEntity(Long id, Long userId, Long professionalId, Long serviceId, LocalDateTime appointmentDate, AppointmentStatus status, LocalDateTime createdAt){
        this.id = id;
        this.userId = userId;
        this.professionalId = professionalId;
        this.serviceId = serviceId;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Long getProfessionalId() { return professionalId; }
    public Long getServiceId() { return serviceId; }
    public LocalDateTime getAppointmentDate() { return appointmentDate; }
    public AppointmentStatus getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setProfessionalId(Long professionalId) { this.professionalId = professionalId; }
    public void setServiceId(Long serviceId) { this.serviceId = serviceId; }
    public void setAppointmentDate(LocalDateTime appointmentDate) { this.appointmentDate = appointmentDate; }
    public void setStatus(AppointmentStatus status) { this.status = status; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}