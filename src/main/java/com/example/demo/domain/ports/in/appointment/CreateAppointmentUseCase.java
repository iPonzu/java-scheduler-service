package com.example.demo.domain.ports.in.appointment;
import com.example.demo.application.dto.appointment.AppointmentResult;
import com.example.demo.application.dto.appointment.CreateAppointmentCommand;

public interface CreateAppointmentUseCase {
    AppointmentResult execute(CreateAppointmentCommand command);
}