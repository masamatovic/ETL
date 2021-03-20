package com.example.smartcat.controller;

import ch.qos.logback.classic.sift.SiftAction;
import com.example.smartcat.model.Shift;
import com.example.smartcat.service.ShiftGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ShiftController {

    @Autowired
    ShiftGenerator generator;

    @GetMapping("/shift")
    public ResponseEntity<ArrayList<Shift>> getShifts () {
        ArrayList<Shift> shifts = new ArrayList<>();
        shifts = generator.generateListOfShift();
        return new ResponseEntity<ArrayList<Shift>>(shifts, HttpStatus.OK);
    }

}
