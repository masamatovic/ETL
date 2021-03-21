package com.example.smartcat.service;

import com.example.smartcat.model.Break;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BreakGenerator {

    @Autowired
    RandomGenerator randomGenerator;

    static final long ONE_MINUTE_IN_MILLIS = 60000;
    static int sumOfLength;

    public ArrayList<Break> generateShiftBreaks(long startDate, long endDate, Long shiftId){
        //restart counter
        sumOfLength = 0;
        ArrayList<Break> breaks = new ArrayList<>();
        if (breaks.isEmpty()){
            Break firstBreak = generateBreak(startDate, endDate, shiftId);
            breaks.add(firstBreak);
            sumOfLength = firstBreak.getLength();
        }
        while (sumOfLength <= 30 ) {
            //end of last break
            long newStartDate = breaks.get(breaks.size()-1).getFinish();
            Break newBreak = generateBreak(newStartDate, endDate, shiftId);
            //preventing the creation of a break an hour before the end of the shift
            if (endDate - newBreak.getStart() >= 60*ONE_MINUTE_IN_MILLIS) {
                breaks.add(newBreak);
                sumOfLength+=newBreak.getLength();
            }
            else
                break;
        }
        return breaks;
    }

    public Break generateBreak(long startDate, long endDate, Long shiftId){
        Break aBreak = new Break();
        aBreak.setId(randomGenerator.generateId());
        aBreak.setShiftId(shiftId);
        long randMilliseconds = startDate + (long) (Math.random() * (endDate - startDate));
        aBreak.setStart(randMilliseconds);
        int length = randomGenerator.generateLength(10, 30);
        aBreak.setLength(length);
        aBreak.setFinish(randMilliseconds + length*ONE_MINUTE_IN_MILLIS );
        if ((float)Math.random() > .5){
            aBreak.setPaid(false);
        } else {
            aBreak.setPaid(true);
        }
        return aBreak;
    }
}
