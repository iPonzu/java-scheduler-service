package com.example.demo.domain.model; 

public class Professional {
    private Long professionalId;
    private String name;
    private String speciality;

    public Professional(Long professionalId, String name, String speciality) {
        this.professionalId = professionalId;
        this.name = name;
        this.speciality = speciality;
    }

    public Long getProfessionalId() {
        return professionalId;
    }
    public String getName() {
        return name;
    }
    public String getSpeciality() {
        return speciality;
    }
}
