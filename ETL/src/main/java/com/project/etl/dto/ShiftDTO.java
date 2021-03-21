package com.project.etl.dto;

import com.project.etl.enums.Status;

import java.util.ArrayList;

public class ShiftDTO {
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

    ArrayList<BreakDTO> breaks = new ArrayList<>();
    ArrayList<AllowanceDTO> allowances = new ArrayList<>();
    ArrayList<AwardInterpretationDTO> awardInterpretations = new ArrayList<>();

    public ShiftDTO() {
    }

    public ShiftDTO(Long id, Long timeSheetId, Long userId, String date, Long start, Long finish, Long departmentId, String subCostCentre, String tag, Long tagId, Status status, String metadata, Long leaveRequestId, Long shiftFeedBackId, Long approvedBy, Long approvedAt, Float cost, Long updatedAt, Long recordId, Long lastCostedAt, ArrayList<BreakDTO> breaks, ArrayList<AllowanceDTO> allowances, ArrayList<AwardInterpretationDTO> awardInterpretations) {
        this.id = id;
        this.timeSheetId = timeSheetId;
        this.userId = userId;
        this.date = date;
        this.start = start;
        this.finish = finish;
        this.departmentId = departmentId;
        this.subCostCentre = subCostCentre;
        this.tag = tag;
        this.tagId = tagId;
        this.status = status;
        this.metadata = metadata;
        this.leaveRequestId = leaveRequestId;
        this.shiftFeedBackId = shiftFeedBackId;
        this.approvedBy = approvedBy;
        this.approvedAt = approvedAt;
        this.cost = cost;
        this.updatedAt = updatedAt;
        this.recordId = recordId;
        this.lastCostedAt = lastCostedAt;
        this.breaks = breaks;
        this.allowances = allowances;
        this.awardInterpretations = awardInterpretations;
    }

    public ShiftDTO(Long id, Long timeSheetId, Long userId, String date, Long start, Long finish, Long departmentId, String subCostCentre, String tag, Long tagId, Status status, String metadata, Long leaveRequestId, Long shiftFeedBackId, Long approvedBy, Long approvedAt, Float cost, Long updatedAt, Long recordId, Long lastCostedAt) {
        this.id = id;
        this.timeSheetId = timeSheetId;
        this.userId = userId;
        this.date = date;
        this.start = start;
        this.finish = finish;
        this.departmentId = departmentId;
        this.subCostCentre = subCostCentre;
        this.tag = tag;
        this.tagId = tagId;
        this.status = status;
        this.metadata = metadata;
        this.leaveRequestId = leaveRequestId;
        this.shiftFeedBackId = shiftFeedBackId;
        this.approvedBy = approvedBy;
        this.approvedAt = approvedAt;
        this.cost = cost;
        this.updatedAt = updatedAt;
        this.recordId = recordId;
        this.lastCostedAt = lastCostedAt;
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

    public Long getShiftFeedBackId() {
        return shiftFeedBackId;
    }

    public void setShiftFeedBackId(Long shiftFeedBackId) {
        this.shiftFeedBackId = shiftFeedBackId;
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

    public ArrayList<BreakDTO> getBreaks() {
        return breaks;
    }

    public void setBreaks(ArrayList<BreakDTO> breaks) {
        this.breaks = breaks;
    }

    public ArrayList<AllowanceDTO> getAllowances() {
        return allowances;
    }

    public void setAllowances(ArrayList<AllowanceDTO> allowances) {
        this.allowances = allowances;
    }

    public ArrayList<AwardInterpretationDTO> getAwardInterpretations() {
        return awardInterpretations;
    }

    public void setAwardInterpretations(ArrayList<AwardInterpretationDTO> awardInterpretations) {
        this.awardInterpretations = awardInterpretations;
    }


}
