package com.example.demo.config.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.application.usecase.appointment.CreateAppointmentService;
import com.example.demo.domain.ports.in.appointment.CreateAppointmentUseCase;
import com.example.demo.domain.ports.out.AppointmentRepositoryPort;
import com.example.demo.domain.ports.out.ClockPort;
import com.example.demo.domain.ports.out.ProfessionalRepositoryPort;
import com.example.demo.domain.ports.out.ServiceRepositoryPort;
import com.example.demo.domain.ports.out.UserRepositoryPort;

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
