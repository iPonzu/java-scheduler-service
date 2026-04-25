package com.example.demo.application.dto.appointment;
import java.time.LocalDateTime;

public record CreateAppointmentCommand(
        Long userId,
        Long serviceId,
        Long professionalId,
        LocalDateTime appointmentDate
) {
}