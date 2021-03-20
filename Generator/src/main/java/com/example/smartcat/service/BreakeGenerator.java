package com.example.smartcat.service;

import com.example.smartcat.model.Break;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BreakeGenerator {

    @Autowired
    ShiftGenerator shiftGenerator;

    static final long ONE_MINUTE_IN_MILLIS=60000;
    static int sumOfLength;

    public ArrayList<Break> generateShiftBreaks(long startDate, long endDate, Long shiftId){
        //resart counter
        sumOfLength = 0;
        ArrayList<Break> breaks = new ArrayList<>();
        if (breaks.size() == 0){
            Break firstBreak = generateBraek(startDate, endDate, shiftId);
            breaks.add(firstBreak);
            sumOfLength = firstBreak.getLength();
        }
        while (sumOfLength <= 60 ) {
            //end of last break
           long newStartDate = breaks.get(breaks.size()-1).getFinish();
            //preventing the creation of a break an hour before the end of the shift
            if (endDate - newStartDate >= 60*ONE_MINUTE_IN_MILLIS) {
                Break newBreak = generateBraek(newStartDate, endDate, shiftId);
                breaks.add(newBreak);
                sumOfLength+=newBreak.getLength();
            }
            else
                break;
        }
        return breaks;
    }

    public Break generateBraek(long startDate, long endDate, Long shiftId){
        Break aBreak = new Break();
        aBreak.setId(shiftGenerator.generateId());
        aBreak.setShiftId(shiftId);
        long randMilliseconds = startDate + (long) (Math.random() * (endDate - startDate));
        aBreak.setStart(randMilliseconds);
        int length = this.generateLength();
        aBreak.setLength(length);
        aBreak.setFinish(randMilliseconds + length*ONE_MINUTE_IN_MILLIS );
        aBreak.setPaid(false);
        return aBreak;
    }

    public int generateLength(){
        int leftLimit = 10;
        int rightLimit = 60;
        return leftLimit + (int) (Math.random() * (rightLimit - leftLimit));
    }


}
