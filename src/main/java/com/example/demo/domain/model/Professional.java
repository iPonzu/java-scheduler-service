package com.example.demo.domain.model; 

public class Professional {
    private Long id;
    private String name;
    private String speciality;

    public Professional(
        Long id, 
        String name, 
        String speciality
    ) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSpeciality() {
        return speciality;
    }
}