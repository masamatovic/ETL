package com.project.etl.model;

import javax.persistence.*;

@Entity
public class Allowance {

    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private Float value;
    @Column
    private Float cost;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Shift shift;

    public Allowance() {
    }

    public Allowance(Long id, String name, Float value, Float cost, Shift shift) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.cost = cost;
        this.shift = shift;
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

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }
}
