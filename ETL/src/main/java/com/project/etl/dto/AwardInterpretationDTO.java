package com.project.etl.dto;

public class AwardInterpretationDTO {
    private Float units;
    private String date;
    private String exportName;
    private String secondaryExportName;
    private Boolean ordinary_hours;
    private Float cost;
    private Long from;
    private Long to;

    public AwardInterpretationDTO() {
    }

    public AwardInterpretationDTO(Float units, String date, String exportName, String secondaryExportName, Boolean ordinary_hours, Float cost, Long from, Long to) {
        this.units = units;
        this.date = date;
        this.exportName = exportName;
        this.secondaryExportName = secondaryExportName;
        this.ordinary_hours = ordinary_hours;
        this.cost = cost;
        this.from = from;
        this.to = to;
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
