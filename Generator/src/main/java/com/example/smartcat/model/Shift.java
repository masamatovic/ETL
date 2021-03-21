package com.example.smartcat.model;

import com.example.smartcat.enums.Status;

import java.util.ArrayList;

public class Shift {
    Long id;
    Long timeSheetId;
    Long userId;
    String date;
    Long start;
    Long finish;
    Long departmentId;
    String subCostCentre;
    String tag;
    Long tagId;
    Status status;
    String metadata;
    Long leaveRequestId;
    Long shiftFeedBackId;
    Long approvedBy;
    Long approvedAt;
    Float cost;
    Long updatedAt;
    Long recordId;
    Long lastCostedAt;

    ArrayList<Break> breaks = new ArrayList<>();
    ArrayList<Allowance> allowances = new ArrayList<>();
    ArrayList<AwardInterpretation> awardInterpretations = new ArrayList<>();

    public Shift() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimeSheetId() {
        return timeSheetId;
    }

    public void setTimeSheetId(Long timeSheetId) {
        this.timeSheetId = timeSheetId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getSubCostCentre() {
        return subCostCentre;
    }

    public void setSubCostCentre(String subCostCentre) {
        this.subCostCentre = subCostCentre;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public Long getLeaveRequestId() {
        return leaveRequestId;
    }

    public void setLeaveRequestId(Long leaveRequestId) {
        this.leaveRequestId = leaveRequestId;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(Long approvedAt) {
        this.approvedAt = approvedAt;
    }

    public ArrayList<Break> getBreaks() {
        return breaks;
    }

    public void setBreaks(ArrayList<Break> breaks) {
        this.breaks = breaks;
    }

    public ArrayList<Allowance> getAllowances() {
        return allowances;
    }

    public void setAllowances(ArrayList<Allowance> allowances) {
        this.allowances = allowances;
    }

    public ArrayList<AwardInterpretation> getAwardInterpretations() {
        return awardInterpretations;
    }

    public void setAwardInterpretations(ArrayList<AwardInterpretation> awardInterpretations) {
        this.awardInterpretations = awardInterpretations;
    }

    public Long getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Long approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getLastCostedAt() {
        return lastCostedAt;
    }

    public void setLastCostedAt(Long lastCostedAt) {
        this.lastCostedAt = lastCostedAt;
    }

    public Long getShiftFeedBackId() {
        return shiftFeedBackId;
    }

    public void setShiftFeedBackId(Long shiftFeedBackId) {
        this.shiftFeedBackId = shiftFeedBackId;
    }
}
