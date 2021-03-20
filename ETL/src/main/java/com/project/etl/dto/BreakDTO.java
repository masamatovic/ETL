package com.project.etl.dto;

public class BreakDTO {
    Long id;
    Long shiftId;
    Long start;
    Long finish;
    int length;
    Boolean paid;

    public BreakDTO() {
    }

    public BreakDTO(Long id, Long shiftId, Long start, Long finish, int length, Boolean paid) {
        this.id = id;
        this.shiftId = shiftId;
        this.start = start;
        this.finish = finish;
        this.length = length;
        this.paid = paid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShiftId() {
        return shiftId;
    }

    public void setShiftId(Long shiftId) {
        this.shiftId = shiftId;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getFinish() {
        return finish;
    }

    public void setFinish(Long finish) {
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
}
