package com.example.demo.application.dto.appointment;
import com.example.demo.domain.enums.AppointmentStatus;
import java.time.LocalDateTime;

public record AppointmentResult(
    Long id,
    String costumerName,
    String serviceName,
    String professionalName,
    LocalDateTime appointmentDate,
    AppointmentStatus status
){

}
    

