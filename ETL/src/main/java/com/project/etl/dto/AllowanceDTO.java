package com.project.etl.dto;

public class AllowanceDTO {
    private Long id;
    private String name;
    private Float value;
    private Float cost;
    public AllowanceDTO() {
    }

    public AllowanceDTO(Long id, String name, Float value, Float cost) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }
}
