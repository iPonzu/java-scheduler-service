package com.example.demo.config.bean;

import com.example.demo.application.usecase.CreateAppointmentService;
import com.example.demo.domain.ports.out.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.domain.ports.in.CreateAppointmentUseCase;

@Configuration
public class UseConfig {
    @Bean
    public CreateAppointmentUseCase createAppointmentUseCase(
        UserRepositoryPort userRepositoryPort,
        ServiceRepositoryPort serviceRepositoryPort,
        ProfessionalRepositoryPort professionalRepositoryPort,
        AppointmentRepositoryPort appointmentRepositoryPort,
        ClockPort clockPort
    ){
        return new CreateAppointmentService(
            userRepositoryPort,
            serviceRepositoryPort,
            professionalRepositoryPort,
            appointmentRepositoryPort,
            clockPort
        );
    }
    // @Bean
    // public ClockPort clockPort() {
    //     return new SystemClockAdapter();
    // }
}
