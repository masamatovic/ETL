package com.example.smartcat.service;

import com.example.smartcat.model.AwardInterpretation;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AwardInterpretationGenerator {

    @Autowired
    RandomGenerator randomGenerator;

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
        awardInterpretation.setCost(randomGenerator.randomFloat(1f, 100f));
        awardInterpretation.setUnits(randomGenerator.randomFloat(0f, 10f));
        Lorem lorem = LoremIpsum.getInstance();
        awardInterpretation.setExportName(lorem.getWords(1, 5));
        if ((float)Math.random() > .5){
            awardInterpretation.setOrdinary_hours(true);
        } else {
            awardInterpretation.setOrdinary_hours(false);
        }
        awardInterpretation.setDate(date);
        long randMilliseconds = start + (long) (Math.random() * (end - start));
        awardInterpretation.setFrom(randMilliseconds);
        awardInterpretation.setTo(randMilliseconds + randomGenerator.generateLength(1, 10) * ONE_MINUTE_IN_MILLIS);
        return awardInterpretation;
    }

}
