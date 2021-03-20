package com.project.etl.model;


import com.project.etl.enums.Status;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Shift {
    @Id
    @Column
    Long id;
    @Column
    Long timeSheetId;
    @Column
    Long userId;
    @Column
    String date;
    @Column
    String start;
    @Column
    String finish;
    @Column
    Long departmentId;
    @Column
    String subCostCentre;
    @Column
    String tag;
    @Column
    Long tagId;
    @Enumerated(EnumType.STRING)
    Status status;
    @Column
    String metadata;
    @Column
    Long leaveRequestId;
    @Column
    String shiftFeedBackId;
    @Column
    Long approvedBy;
    @Column
    String approvedAt;
    @Column
    Float cost;
    @Column
    String updatedAt;
    @Column
    Long recordId;
    @Column
    String lastCostedAt;

    @OneToMany(mappedBy="shift")
    List<Break> breaks = new ArrayList<>();
    @OneToMany(mappedBy="shift")
    List<Allowance> allowances = new ArrayList<>();
    @OneToMany(mappedBy="shift")
    List<AwardInterpretation> awardInterpretations = new ArrayList<>();


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


    public List<Break> getBreaks() {
        return breaks;
    }

    public void setBreaks(List<Break> breaks) {
        this.breaks = breaks;
    }

    public List<Allowance> getAllowances() {
        return allowances;
    }

    public void setAllowances(List<Allowance> allowances) {
        this.allowances = allowances;
    }

    public List<AwardInterpretation> getAwardInterpretations() {
        return awardInterpretations;
    }

    public void setAwardInterpretations(List<AwardInterpretation> awardInterpretations) {
        this.awardInterpretations = awardInterpretations;
    }

    public void setAwardInterpretations(ArrayList<AwardInterpretation> awardInterpretations) {
        this.awardInterpretations = awardInterpretations;
    }

    public String getShiftFeedBackId() {
        return shiftFeedBackId;
    }

    public void setShiftFeedBackId(String shiftFeedBackId) {
        this.shiftFeedBackId = shiftFeedBackId;
    }

    public Long getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Long approvedBy) {
        this.approvedBy = approvedBy;
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

    public String getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(String approvedAt) {
        this.approvedAt = approvedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getLastCostedAt() {
        return lastCostedAt;
    }

    public void setLastCostedAt(String lastCostedAt) {
        this.lastCostedAt = lastCostedAt;
    }
}
