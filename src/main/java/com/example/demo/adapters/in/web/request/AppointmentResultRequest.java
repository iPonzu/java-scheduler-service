package com.example.demo.adapters.in.web.request;

import com.example.demo.domain.enums.AppointmentStatus;
import java.time.LocalDateTime;

public record AppointmentResultRequest(
    Long id,
    String customerName,
    String serviceName,
    String professionalName,
    LocalDateTime appointmentDate,
    AppointmentStatus status
){
    
}