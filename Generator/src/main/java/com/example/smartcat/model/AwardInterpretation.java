package com.example.smartcat.model;

public class AwardInterpretation {
    private Float units;
    private String date;
    private String exportName;
    private String secondaryExportName;
    private Boolean ordinary_hours;
    private Float cost;
    private Long from;
    private Long to;

    public AwardInterpretation() {
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

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }
}
