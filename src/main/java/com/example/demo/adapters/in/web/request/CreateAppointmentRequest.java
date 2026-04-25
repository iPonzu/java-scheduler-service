package com.example.demo.adapters.in.web.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateAppointmentRequest( 
    @NotNull Long serviceId,
    @NotNull Long professionalId,
    @NotNull @Future LocalDateTime appointmentDate

){
    
}
