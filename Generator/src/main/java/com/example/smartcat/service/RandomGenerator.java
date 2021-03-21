package com.example.smartcat.service;


import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class RandomGenerator {

    public Long generateId(){
        long leftLimit = 1000L;
        long rightLimit = 10000L;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }
    //random day in last week
    public Date generateDate(){
        Date endDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date startDate = cal.getTime();

        long randMilliseconds = startDate.getTime() + (long) (Math.random() * (endDate.getTime() - startDate.getTime()));
        Date generatedDate = new Date(randMilliseconds);
        return generatedDate;
    }

    public int generateLength(int leftLimit, int  rightLimit){
        return leftLimit + (int) (Math.random() * (rightLimit - leftLimit));
    }

    public Float randomFloat (Float min, Float max)
    {
        return min + (float) (Math.random() * (max - min));
    }
    public Long randomDate (long start, long end)
    {
        return end + (long) (Math.random() * (start - end));
    }


}
