package com.example.smartcat.service;

import com.example.smartcat.model.Allowance;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AllowanceGenerator {

    public ArrayList<Allowance> generateListOfAllownace(){
        //the list can have from 1 to 5 elements
        ArrayList<Allowance> allowances = new ArrayList<>();
        int numberOfAllowances = 1 + (int) (Math.random() * (5));
        for (int i =0 ; i<numberOfAllowances; i++) {
            allowances.add(generateAllownace());
        }
        return allowances;
    }

    public Allowance generateAllownace(){
        Lorem lorem = LoremIpsum.getInstance();
        Allowance allowance = new Allowance();
        allowance.setId(generateId());
        allowance.setName(lorem.getWords(1, 5));
        //
        allowance.setValue(randomFloat(1f, 10f));
        allowance.setCost(randomFloat(10f, 100f));
        return allowance;
    }

    public Long generateId(){
        long leftLimit = 1000L;
        long rightLimit = 10000L;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }
    public Float randomFloat (Float min, Float max)
    {
        return min + (float) (Math.random() * (max - min));
    }
}
