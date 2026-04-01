package com.example.demo.domain.model;
import java.math.BigDecimal;

public class ServiceItem {
    private Long id;
    private String name;
    private String description;
    private Integer durationInMinutes;
    private BigDecimal price;

    public ServiceItem(Long id, String name, String description, Integer durationInMinutes, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.durationInMinutes = durationInMinutes;
        this.price = price;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Integer getDurationInMinutes() {
        return durationInMinutes;
    }
    public BigDecimal getPrice() {
        return price;
    }
}
