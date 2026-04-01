package com.example.demo.domain.model;
import com.example.demo.domain.enums.AppointmentStatus;
import java.time.LocalDateTime;

public class Appointment {

    private Long id;
    private User user;
    private Professional professional;
    private ServiceItem serviceItem;
    private LocalDateTime appointmentDate;
    private AppointmentStatus status;
    private LocalDateTime createdAt;

    public Appointment(
            Long id,
            User user,
            Professional professional,
            ServiceItem serviceItem,
            LocalDateTime appointmentDate,
            AppointmentStatus status,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.user = user;
        this.professional = professional;
        this.serviceItem = serviceItem;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.createdAt = createdAt;
    }

    public boolean isCanceled() {
        return AppointmentStatus.CANCELADO.equals(this.status);
    }

    public void cancel() {
        if (!isCanceled()) {
            this.status = AppointmentStatus.CANCELADO;
        }
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Professional getProfessional() {
        return professional;
    }

    public ServiceItem getServiceItem() {
        return serviceItem;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}