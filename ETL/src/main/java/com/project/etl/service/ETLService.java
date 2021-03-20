package com.project.etl.service;

import com.project.etl.dto.ShiftDTO;
import com.project.etl.model.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ETLService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TransformService transformService;

    public ShiftDTO[] extract(){
        ResponseEntity<ShiftDTO[]> response = restTemplate.getForEntity(System.getenv("API"), ShiftDTO[].class );
        System.out.println("ovde cu da ispisem size: " + response.getBody());
        for (ShiftDTO shiftDTO : response.getBody()){
            Shift shift = transformService.transformShift(shiftDTO);
            transformService.transformBreak(shiftDTO, shift);
            transformService.transformAllowance(shiftDTO, shift);
            transformService.transformAwardInterpretation(shiftDTO, shift);
        }
        return response.getBody();
    }

}
