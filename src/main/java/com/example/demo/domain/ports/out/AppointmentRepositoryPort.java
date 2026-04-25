package com.example.demo.domain.ports.out;

import com.example.demo.domain.model.Appointment;

import java.time.LocalDateTime;

public interface AppointmentRepositoryPort {
    boolean existsByProfessionalIdAndAppointmentDate(Long professionalId, LocalDateTime appointmentDate);
    Appointment save(Appointment appointment);
}
