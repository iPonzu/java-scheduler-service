package com.example.demo.application.dto.appointment;
import java.time.LocalDateTime;

public record CancelAppointmentCommand(
        Long appointmentId,
        LocalDateTime cancellationDate
){
    
}
    

