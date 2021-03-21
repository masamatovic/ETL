package com.example.smartcat.service;

import com.example.smartcat.model.Allowance;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AllowanceGenerator {

    @Autowired
    RandomGenerator randomGenerator;

    public ArrayList<Allowance> generateListOfAllowance(){
        //the list can have from 1 to 5 elements
        ArrayList<Allowance> allowances = new ArrayList<>();
        int numberOfAllowances = 1 + (int) (Math.random() * (5));
        for (int i =0 ; i<numberOfAllowances; i++) {
            allowances.add(generateAllowance());
        }
        return allowances;
    }

    public Allowance generateAllowance(){
        Lorem lorem = LoremIpsum.getInstance();
        Allowance allowance = new Allowance();
        allowance.setId(randomGenerator.generateId());
        allowance.setName(lorem.getWords(1, 5));
        allowance.setValue(randomGenerator.randomFloat(1f, 10f));
        allowance.setCost(randomGenerator.randomFloat(10f, 100f));
        return allowance;
    }

}
