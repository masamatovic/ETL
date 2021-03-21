package com.project.etl.service;

import com.project.etl.dto.AllowanceDTO;
import com.project.etl.dto.AwardInterpretationDTO;
import com.project.etl.dto.BreakDTO;
import com.project.etl.dto.ShiftDTO;
import com.project.etl.model.Allowance;
import com.project.etl.model.AwardInterpretation;
import com.project.etl.model.Break;
import com.project.etl.model.Shift;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

@Service
public class TransformService {

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

        return shift;
    }

    public ArrayList<Break> transformBreak (ArrayList<BreakDTO> breakDTOS, Shift shift){
        ArrayList<Break> breaks = new ArrayList<>();
        for (BreakDTO breakDTO : breakDTOS){
            Break aBreak = new Break();
            aBreak.setId(breakDTO.getId());
            aBreak.setStart(setDate(breakDTO.getStart()));
            aBreak.setFinish(setDate(breakDTO.getFinish()));
            aBreak.setLength(breakDTO.getLength());
            aBreak.setPaid(breakDTO.getPaid());
            aBreak.setShift(shift);
            breaks.add(aBreak);
        }
        return breaks;
    }

    public ArrayList<Allowance> transformAllowance ( ArrayList<AllowanceDTO> allowanceDTOS, Shift shift){
        ArrayList<Allowance> allowances = new ArrayList<>();
        for (AllowanceDTO allowanceDTO : allowanceDTOS){
            Allowance allowance = new Allowance();
            allowance.setId(allowanceDTO.getId());
            allowance.setName(allowanceDTO.getName());
            allowance.setValue(allowanceDTO.getValue());
            allowance.setCost(allowanceDTO.getCost());
            allowance.setShift(shift);
            allowances.add(allowance);
        }
        return allowances;
    }

    public ArrayList<AwardInterpretation> transformAwardInterpretation ( ArrayList<AwardInterpretationDTO> awardInterpretationDTOS, Shift shift){
        ArrayList<AwardInterpretation> awardInterpretations = new ArrayList<>();
        for (AwardInterpretationDTO awardInterpretationDTO : awardInterpretationDTOS){
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
            awardInterpretations.add(awardInterpretation);
        }
        return awardInterpretations;
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
