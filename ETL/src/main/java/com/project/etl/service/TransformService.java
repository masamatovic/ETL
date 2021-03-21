package com.project.etl.service;

import com.project.etl.dto.AllowanceDTO;
import com.project.etl.dto.AwardInterpretationDTO;
import com.project.etl.dto.BreakDTO;
import com.project.etl.dto.ShiftDTO;
import com.project.etl.model.Allowance;
import com.project.etl.model.AwardInterpretation;
import com.project.etl.model.Break;
import com.project.etl.model.Shift;
import com.project.etl.repository.AllowanceRepository;
import com.project.etl.repository.AwardInterpretationRepository;
import com.project.etl.repository.BreakRepository;
import com.project.etl.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Service
public class TransformService {

    @Autowired
    ShiftRepository shiftRepository;

    @Autowired
    BreakRepository breakRepository;

    @Autowired
    AllowanceRepository allowanceRepository;

    @Autowired
    AwardInterpretationRepository awardInterpretationRepository;


    public Shift transformShift(ShiftDTO shiftDTO){
        Shift shift = new Shift();
        shift.setId(shiftDTO.getId());
        shift.setTimeSheetId(shiftDTO.getTimeSheetId());
        shift.setUserId(shiftDTO.getUserId());
        shift.setDate(shiftDTO.getDate());
        shift.setStart(setDate(shiftDTO.getStart()));
        shift.setFinish(setDate(shiftDTO.getFinish()));
        shift.setDepartmentId(shiftDTO.getDepartmentId());
        shift.setSubCostCentre(shiftDTO.getSubCostCentre());
        shift.setTag(shiftDTO.getTag());
        shift.setTagId(shiftDTO.getTagId());
        shift.setStatus(shiftDTO.getStatus());
        shift.setMetadata(shiftDTO.getMetadata());
        shift.setLeaveRequestId(shiftDTO.getId());
        shift.setShiftFeedBackId(shiftDTO.getShiftFeedBackId());
        shift.setApprovedBy(shiftDTO.getApprovedBy());
        shift.setApprovedAt(setDate(shiftDTO.getApprovedAt()));
        shift.setCost(shiftDTO.getCost());
        shift.setUpdatedAt(setDate(shiftDTO.getUpdatedAt()));
        shift.setRecordId(shiftDTO.getRecordId());
        shift.setLastCostedAt(setDate(shiftDTO.getLastCostedAt()));

        Shift newShift = shiftRepository.save(shift);

        return newShift;

    }
    public void transformBreak (ShiftDTO shiftDTO, Shift shift){
        for (BreakDTO breakDTO : shiftDTO.getBreaks()){
            Break aBreak = new Break();
            aBreak.setId(breakDTO.getId());
            aBreak.setStart(setDate(breakDTO.getStart()));
            aBreak.setFinish(setDate(breakDTO.getFinish()));
            aBreak.setLength(breakDTO.getLength());
            aBreak.setPaid(breakDTO.getPaid());

            aBreak.setShift(shift);
            breakRepository.save(aBreak);
        }
    }
    public void transformAllowance (ShiftDTO shiftDTO, Shift shift){
        for (AllowanceDTO allowanceDTO : shiftDTO.getAllowances()){
            Allowance allowance = new Allowance();
            allowance.setId(allowanceDTO.getId());
            allowance.setName(allowanceDTO.getName());
            allowance.setValue(allowanceDTO.getValue());
            allowance.setCost(allowanceDTO.getCost());
            allowance.setShift(shift);
            allowanceRepository.save(allowance);
        }
    }

    public void transformAwardInterpretation (ShiftDTO shiftDTO, Shift shift){
        for (AwardInterpretationDTO awardInterpretationDTO : shiftDTO.getAwardInterpretations()){
            AwardInterpretation awardInterpretation = new AwardInterpretation();
            awardInterpretation.setUnits(awardInterpretationDTO.getUnits());
            awardInterpretation.setDate(awardInterpretationDTO.getDate());
            awardInterpretation.setExportName(awardInterpretationDTO.getExportName());
            awardInterpretation.setSecondaryExportName(awardInterpretationDTO.getSecondaryExportName());
            awardInterpretation.setOrdinary_hours(awardInterpretationDTO.getOrdinary_hours());
            awardInterpretation.setCost(awardInterpretationDTO.getCost());
            awardInterpretation.setDate_from(setDate(awardInterpretationDTO.getFrom()));
            awardInterpretation.setDate_to(setDate(awardInterpretationDTO.getTo()));
            awardInterpretation.setShift(shift);
            awardInterpretationRepository.save(awardInterpretation);
        }
    }

    public String setDate(Long milliseconds){
        if (milliseconds == null){
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("EST"));
        Date date = new Date(milliseconds);
        return formatter.format(date);
    }

}
