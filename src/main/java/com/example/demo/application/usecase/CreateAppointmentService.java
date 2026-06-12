package com.example.demo.application.usecase;
import com.example.demo.application.dto.appointment.AppointmentResult;
import com.example.demo.application.dto.appointment.CreateAppointmentCommand;
import com.example.demo.domain.enums.AppointmentStatus;
import com.example.demo.domain.exception.AppointmentConflictException;
import com.example.demo.domain.exception.BusinessException;
import com.example.demo.domain.exception.ResourceNotFoundException;
import com.example.demo.domain.model.Appointment;
import com.example.demo.domain.model.Professional;
import com.example.demo.domain.model.ServiceItem;
import com.example.demo.domain.model.User;
import com.example.demo.domain.ports.in.CreateAppointmentUseCase;
import com.example.demo.domain.ports.out.AppointmentRepositoryPort;
import com.example.demo.domain.ports.out.ClockPort;
import com.example.demo.domain.ports.out.ProfessionalRepositoryPort;
import com.example.demo.domain.ports.out.ServiceRepositoryPort;
import com.example.demo.domain.ports.out.UserRepositoryPort;

public class CreateAppointmentService implements CreateAppointmentUseCase {
    private final UserRepositoryPort userRepositoryPort;
    private final ServiceRepositoryPort serviceRepositoryPort;
    private final ProfessionalRepositoryPort professionalRepositoryPort;
    private final AppointmentRepositoryPort appointmentRepositoryPort;
    private final ClockPort clockPort;

    public CreateAppointmentService(
        UserRepositoryPort userRepositoryPort,
        ServiceRepositoryPort serviceRepositoryPort,
        ProfessionalRepositoryPort professionalRepositoryPort,
        AppointmentRepositoryPort appointmentRepositoryPort,
        ClockPort clockPort
    ) {
        this.userRepositoryPort = userRepositoryPort;
        this.serviceRepositoryPort = serviceRepositoryPort;
        this.professionalRepositoryPort = professionalRepositoryPort;
        this.appointmentRepositoryPort = appointmentRepositoryPort;
        this.clockPort = clockPort;   
    }

    @Override
    public AppointmentResult execute(CreateAppointmentCommand command){
        User user = userRepositoryPort.findById(command.userId())
            .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        
        ServiceItem serviceItem = serviceRepositoryPort.findById(command.serviceId())
            .orElseThrow(() -> new ResourceNotFoundException("Serviço não encontrado"));

        Professional professional = professionalRepositoryPort.findById(command.professionalId())
            .orElseThrow(() -> new ResourceNotFoundException("Profissional não encontrado"));

        if(command.appointmentDate().isBefore(clockPort.now())){
            throw new BusinessException("A data do agendamento deve ser no futuro");
        }
        boolean alreadyBooked = appointmentRepositoryPort
            .existsByProfessionalIdAndAppointmentDate(professional.getId(), command.appointmentDate());
        if(alreadyBooked){
            throw new AppointmentConflictException("O profissional já possui um agendamento nesse horário");
        }
        Appointment appointment = new Appointment(
            null,
            user,
            professional,
            serviceItem,
            command.appointmentDate(),
            AppointmentStatus.PENDENTE,
            clockPort.now()
        );

        Appointment savedAppointment = appointmentRepositoryPort.save(appointment);
        return new AppointmentResult(
                savedAppointment.getId(),
                savedAppointment.getUser().getName(),
                savedAppointment.getServiceItem().getName(),
                savedAppointment.getProfessional().getName(),
                savedAppointment.getAppointmentDate(),
                savedAppointment.getStatus()
        );
    }
}