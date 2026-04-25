package com.example.demo.adapters.in.web.controller;

import com.example.demo.adapters.in.web.request.CreateAppointmentRequest;
import com.example.demo.adapters.in.web.response.AppointmentResponse;
import com.example.demo.application.dto.appointment.AppointmentResult;
import com.example.demo.application.dto.appointment.CreateAppointmentCommand;
import com.example.demo.domain.ports.in.CreateAppointmentUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final CreateAppointmentUseCase createAppointmentUseCase;

    public AppointmentController(CreateAppointmentUseCase createAppointmentUseCase) {
        this.createAppointmentUseCase = createAppointmentUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentResponse create(
            @RequestBody @Valid CreateAppointmentRequest request,
            Principal principal
    ) {
        Long authenticatedUserId = Long.parseLong(principal.getName());

        AppointmentResult result = createAppointmentUseCase.execute(
                new CreateAppointmentCommand(
                        authenticatedUserId,
                        request.serviceId(),
                        request.professionalId(),
                        request.appointmentDate()
                )
        );

        return new AppointmentResponse(
                result.id(),
                result.customerName(),
                result.serviceName(),
                result.professionalName(),
                result.appointmentDate(),
                result.status()
        );
    }
}