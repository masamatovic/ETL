package com.example.smartcat.service;

import com.example.smartcat.model.AwardInterpretation;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AwardInterpretationGenerator {

    static final long ONE_MINUTE_IN_MILLIS=60000;

    public ArrayList<AwardInterpretation> generateListOfAwardInterpretations(String date, Long start, Long end){
        //the list can have from 1 to 5 elements
        ArrayList<AwardInterpretation> awardInterpretations = new ArrayList<>();
        int numberOfAwardInterpretation = 1 + (int) (Math.random() * (5));
        for (int i =0 ; i<numberOfAwardInterpretation; i++) {
            awardInterpretations.add(generateAwardInterpretation(date, start, end));
        }
        return awardInterpretations;
    }

    public AwardInterpretation generateAwardInterpretation(String date, Long start, Long end){
        AwardInterpretation awardInterpretation = new AwardInterpretation();
        awardInterpretation.setCost(randomFloat(1f, 100f));
        awardInterpretation.setUnits(randomFloat(0f, 10f));
        Lorem lorem = LoremIpsum.getInstance();
        awardInterpretation.setExportName(lorem.getWords(1, 5));
        awardInterpretation.setOrdinary_hours(true);
        awardInterpretation.setDate(date);
        long randMilliseconds = start + (long) (Math.random() * (end - start));
        awardInterpretation.setFrom(randMilliseconds);
        awardInterpretation.setTo(randMilliseconds + generateLength() * ONE_MINUTE_IN_MILLIS);
        return awardInterpretation;
    }
    public int generateLength(){
        int leftLimit = 1;
        int rightLimit = 10;
        return leftLimit + (int) (Math.random() * (rightLimit - leftLimit));
    }
    public Float randomFloat (Float min, Float max)
    {
        return min + (float) (Math.random() * (max - min));
    }

}
