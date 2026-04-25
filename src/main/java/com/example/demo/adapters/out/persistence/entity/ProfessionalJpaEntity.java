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
    private Long id;

    @Column(name = "professional_name", nullable = false)
    private String name;

    @Column(name = "professional_speciality", nullable = false)
    private String speciality;

    public ProfessionalJpaEntity() {}

    public ProfessionalJpaEntity(Long id, String name, String speciality) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSpeciality() { return speciality; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSpeciality(String speciality) { this.speciality = speciality; }
}
