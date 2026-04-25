package com.example.demo.adapters.out.persistence.adapter;

import com.example.demo.adapters.out.persistence.entity.AppointmentJpaEntity;
import com.example.demo.adapters.out.persistence.repository.SpringDataAppointmentRepository;
import com.example.demo.domain.model.Appointment;
import com.example.demo.domain.ports.out.AppointmentRepositoryPort;

import java.time.LocalDateTime;

public class AppointmentPersistenceAdapter implements AppointmentRepositoryPort {

    private final SpringDataAppointmentRepository repository;

    public AppointmentPersistenceAdapter(SpringDataAppointmentRepository repository){
        this.repository = repository;
    }

    @Override
    public boolean existsByProfessionalIdAndAppointmentDate(Long professionalId, java.time.LocalDateTime appointmentDate){
        return repository.existsByProfessionalIdAndAppointmentDate(professionalId, appointmentDate);
    }
    @Override
    public Appointment save(Appointment appointment){
        AppointmentJpaEntity entity = new AppointmentJpaEntity(
                null,
                appointment.getUser().getId(),
                appointment.getProfessional().getProfessionalId(),
                appointment.getServiceItem().getId(),
                appointment.getAppointmentDate(),
                appointment.getStatus(),
                appointment.getCreatedAt()
        );
        AppointmentJpaEntity savedEntity = repository.save(entity);
        return new Appointment(
                savedEntity.getId(),
                appointment.getUser(),
                appointment.getProfessional(),
                appointment.getServiceItem(),
                savedEntity.getAppointmentDate(),
                savedEntity.getStatus(),
                savedEntity.getCreatedAt()
        );
    }
}
