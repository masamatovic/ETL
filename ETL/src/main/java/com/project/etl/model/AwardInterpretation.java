package com.project.etl.model;


import javax.persistence.*;

@Entity
public class AwardInterpretation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Float units;
    @Column
    private String date;
    @Column
    private String exportName;
    @Column
    private String secondaryExportName;
    @Column
    private Boolean ordinary_hours;
    @Column
    private Float cost;
    @Column
    private String date_from;
    @Column
    private String date_to;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Shift shift;

    public AwardInterpretation() {
    }

    public AwardInterpretation(Float units, String date, String exportName, String secondaryExportName, Boolean ordinary_hours, Float cost, String from, String to, Shift shift) {
        this.units = units;
        this.date = date;
        this.exportName = exportName;
        this.secondaryExportName = secondaryExportName;
        this.ordinary_hours = ordinary_hours;
        this.cost = cost;
        this.date_from = from;
        this.date_to = to;
        this.shift = shift;
    }

    public Float getUnits() {
        return units;
    }

    public void setUnits(Float units) {
        this.units = units;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExportName() {
        return exportName;
    }

    public void setExportName(String exportName) {
        this.exportName = exportName;
    }

    public String getSecondaryExportName() {
        return secondaryExportName;
    }

    public void setSecondaryExportName(String secondaryExportName) {
        this.secondaryExportName = secondaryExportName;
    }

    public Boolean getOrdinary_hours() {
        return ordinary_hours;
    }

    public void setOrdinary_hours(Boolean ordinary_hours) {
        this.ordinary_hours = ordinary_hours;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public String getDate_from() {
        return date_from;
    }

    public void setDate_from(String date_from) {
        this.date_from = date_from;
    }

    public String getDate_to() {
        return date_to;
    }

    public void setDate_to(String date_to) {
        this.date_to = date_to;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }



}
