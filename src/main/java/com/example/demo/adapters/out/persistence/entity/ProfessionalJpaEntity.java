package com.example.demo.adapters.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profissionais")
public class ProfessionalJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professionalId;

    @Column(name = "professional_name", nullable = false)
    private String name;

    @Column(name = "professional_speciality", nullable = false)
    private String speciality;

    public ProfessionalJpaEntity() {}

    public ProfessionalJpaEntity(Long professionalId, String name, String speciality) {
        this.professionalId = professionalId;
        this.name = name;
        this.speciality = speciality;
    }

    public Long getProfessionalId() { return professionalId; }
    public String getName() { return name; }
    public String getSpeciality() { return speciality; }

    public void setProfessionalId(Long professionalId) { this.professionalId = professionalId; }
    public void setName(String name) { this.name = name; }
    public void setSpeciality(String speciality) { this.speciality = speciality; }
}
