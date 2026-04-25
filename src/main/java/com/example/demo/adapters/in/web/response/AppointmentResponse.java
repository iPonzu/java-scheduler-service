package com.example.demo.adapters.in.web.response;

import com.example.demo.domain.enums.AppointmentStatus;
import java.time.LocalDateTime;

public record AppointmentResponse( 
    Long id,
    String customerName,
    String serviceName,
    String professionalName,
    LocalDateTime appointmentDate,
    AppointmentStatus status
){
}
