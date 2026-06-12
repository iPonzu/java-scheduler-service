package com.example.demo.adapters.out.persistence.adapter;

import com.example.demo.adapters.out.persistence.entity.AppointmentJpaEntity;
import com.example.demo.adapters.out.persistence.entity.ProfessionalJpaEntity;
import com.example.demo.adapters.out.persistence.entity.ServiceJpaEntity;
import com.example.demo.adapters.out.persistence.entity.UserJpaEntity;
import com.example.demo.adapters.out.persistence.repository.SpringDataAppointmentRepository;
import com.example.demo.domain.ports.out.AppointmentRepositoryPort;
import com.example.demo.domain.model.Appointment;
import com.example.demo.domain.model.Professional;
import com.example.demo.domain.model.ServiceItem;
import com.example.demo.domain.model.User;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class AppointmentPersistenceAdapter implements AppointmentRepositoryPort {

    private final SpringDataAppointmentRepository repository;

    public AppointmentPersistenceAdapter(SpringDataAppointmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsByProfessionalIdAndAppointmentDate(Long professionalId, LocalDateTime appointmentDate) {
        return repository.existsByProfessionalIdAndAppointmentDate(professionalId, appointmentDate);
    }

    @Override
    public Appointment save(Appointment appointment) {

        AppointmentJpaEntity entity = new AppointmentJpaEntity(
                null,
                appointment.getUser().getId(),
                appointment.getProfessional().getId(),
                appointment.getServiceItem().getId(),
                appointment.getAppointmentDate(),
                appointment.getStatus(),
                appointment.getCreatedAt()
            );

            AppointmentJpaEntity saved = repository.save(entity);

        return new Appointment(
                saved.getId(),
                appointment.getUser(),
                appointment.getProfessional(),
                appointment.getServiceItem(),
                saved.getAppointmentDate(),
                saved.getStatus(),
                saved.getCreatedAt()
        );
    }

    // ================= conversões =================

    private UserJpaEntity toUserEntity(User user) {
        return new UserJpaEntity(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole()
        );
    }

    private ProfessionalJpaEntity toProfessionalEntity(Professional professional) {
        return new ProfessionalJpaEntity(
                professional.getId(),
                professional.getName(),
                professional.getSpeciality()
        );
    }

    private ServiceJpaEntity toServiceEntity(ServiceItem service) {
        return new ServiceJpaEntity(
                service.getId(),
                service.getName(),
                service.getDescription(),
                service.getDurationInMinutes(),
                service.getPrice()
        );
    }
}