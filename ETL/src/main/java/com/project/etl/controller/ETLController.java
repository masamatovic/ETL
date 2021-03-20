package com.project.etl.controller;
import com.project.etl.dto.ShiftDTO;
import com.project.etl.service.ETLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ETLController {

    @Autowired
    ETLService etlService;


    @GetMapping()
    public ResponseEntity<ShiftDTO[]> hi(){
        ShiftDTO[] shifts = etlService.extract();
        return new ResponseEntity<ShiftDTO[]>(shifts, HttpStatus.OK);
    }

}
