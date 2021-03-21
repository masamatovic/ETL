package com.example.smartcat.service;

import com.example.smartcat.enums.Status;
import com.example.smartcat.model.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Service
public class ShiftGenerator {

    private static final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;

    @Autowired
    RandomGenerator randomGenerator;
    @Autowired
    BreakGenerator breakGenerator;
    @Autowired
    AllowanceGenerator allowanceGenerator;
    @Autowired
    AwardInterpretationGenerator awardInterpretationGenerator;

    public ArrayList<Shift> generateListOfShift(){
        ArrayList<Shift> shifts = new ArrayList<>();
        int numberOfShifts =  randomGenerator.randomFloat(10f, 50f).intValue();
        for (int i =0; i < numberOfShifts; i++){
            shifts.add(generateShift());
        }
        return shifts;
    }

    public Shift generateShift() {

        Shift shift = new Shift();
        shift.setId(randomGenerator.generateId());
        shift.setTimeSheetId(randomGenerator.generateId());
        shift.setUserId(randomGenerator.generateId());
        Date date = randomGenerator.generateDate();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        shift.setDate( formatter.format(date));
        shift.setStart(date.getTime());
        // each shift lasts 8 hours
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, 8);
        shift.setFinish(calendar.getTimeInMillis());
        shift.setBreaks(breakGenerator.generateShiftBreaks(shift.getStart(), shift.getFinish(), shift.getId()));
        shift.setDepartmentId(randomGenerator.generateId());
        shift.setTagId(randomGenerator.generateId());
        if ((float)Math.random() > .5){
            shift.setStatus(Status.APPROVED);
            shift.setApprovedBy(randomGenerator.generateId());
            shift.setApprovedAt(randomGenerator.randomDate(shift.getFinish(), shift.getFinish()+ MILLIS_IN_A_DAY));
        } else {
            shift.setStatus(Status.PENDING);
        }
        shift.setLeaveRequestId(randomGenerator.generateId());
        shift.setShiftFeedBackId(randomGenerator.generateId());
        shift.setAllowances(allowanceGenerator.generateListOfAllowance());
        shift.setAwardInterpretations(awardInterpretationGenerator.generateListOfAwardInterpretations(shift.getDate(), shift.getStart(),shift.getFinish()));
        shift.setCost(randomGenerator.randomFloat(1f, 200f));
        shift.setUpdatedAt(randomGenerator.randomDate(shift.getFinish(), shift.getFinish()+ MILLIS_IN_A_DAY));
        shift.setRecordId(randomGenerator.generateId());
        shift.setLastCostedAt(randomGenerator.randomDate(shift.getFinish(), shift.getFinish()+ MILLIS_IN_A_DAY));

        return shift;
    }

}
