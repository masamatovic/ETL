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

    @Autowired
    BreakeGenerator breakeGenerator;
    @Autowired
    AllowanceGenerator allowanceGenerator;
    @Autowired
    AwardInterpretationGenerator awardInterpretationGenerator;

    public ArrayList<Shift> generateListOfShift(){
        ArrayList<Shift> shifts = new ArrayList<>();
        int numberOfShifts =  randomFloat(10f, 50f).intValue();
        for (int i =0; i < numberOfShifts; i++){
            shifts.add(generateShift());
        }
        return shifts;
    }

    public Shift generateShift() {

        Shift shift = new Shift();
        shift.setId(this.generateId());
        shift.setTimeSheetId(this.generateId());
        shift.setUserId(this.generateId());
        Date date = this.generateDate();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        shift.setDate( formatter.format(date));
        shift.setStart(date.getTime());
        // each shift lasts 8 hours
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, 8);
        shift.setFinish(calendar.getTimeInMillis());
        shift.setDepartmentId(this.generateId());
        shift.setTagId(this.generateId());
        shift.setStatus(Status.PENDING);

        //pauzee posle izmenii
        shift.setBreaks(breakeGenerator.generateShiftBreaks(shift.getStart(), shift.getFinish(), shift.getId()));
        shift.setAllowances(allowanceGenerator.generateListOfAllownace());
        shift.setAwardInterpretations(awardInterpretationGenerator.generateListOfAwardInterpretations(shift.getDate(), shift.getStart(),shift.getFinish()));

        shift.setCost(randomFloat(1f, 200f));

        return shift;
    }

    public Long generateId(){
        long leftLimit = 1000L;
        long rightLimit = 10000L;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }

    public Date generateDate(){

        Date endDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date startDate = cal.getTime();

        long randMilliseconds = startDate.getTime() + (long) (Math.random() * (endDate.getTime() - startDate.getTime()));
        Date generatedDate = new Date(randMilliseconds);
        return generatedDate;
    }
    public Float randomFloat (Float min, Float max)
    {
        return min + (float) (Math.random() * (max - min));
    }
}
