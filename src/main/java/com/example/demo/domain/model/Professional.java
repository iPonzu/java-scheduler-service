package com.example.demo.domain.model;

public class Professional {
    private Long id;
    private String name;
    private String speciality;
    private String email;

    public Professional(Long id, String name, String speciality, String email) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.email = email;
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
    public String getEmail() {
        return email;
    }
}
