package com.project.etl.model;

import javax.persistence.*;

@Entity
public class Break {
    @Id
    @Column
    Long id;
    @Column
    String start;
    @Column
    String finish;
    @Column
    int length;
    @Column
    Boolean paid;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Shift shift;


    public Break() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }
}
