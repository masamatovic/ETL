package com.project.etl.service;

import com.project.etl.dto.ShiftDTO;
import com.project.etl.model.Allowance;
import com.project.etl.model.AwardInterpretation;
import com.project.etl.model.Break;
import com.project.etl.model.Shift;
import com.project.etl.repository.AllowanceRepository;
import com.project.etl.repository.AwardInterpretationRepository;
import com.project.etl.repository.BreakRepository;
import com.project.etl.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class ETLService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TransformService transformService;

    @Autowired
    ShiftRepository shiftRepository;

    @Autowired
    BreakRepository breakRepository;

    @Autowired
    AllowanceRepository allowanceRepository;

    @Autowired
    AwardInterpretationRepository awardInterpretationRepository;

    public String extract() throws HttpClientErrorException,HttpServerErrorException{

        ResponseEntity<ShiftDTO[]> response;
        try {
            response = restTemplate.getForEntity(System.getenv("API"), ShiftDTO[].class );
        } catch (HttpStatusCodeException ex) {
            return "Generator server: " + ex.getStatusCode().toString();
        }

        for (ShiftDTO shiftDTO : response.getBody()){
            Shift shift = transformService.transformShift(shiftDTO);
            shiftRepository.save(shift);

            ArrayList<Break> breaks = transformService.transformBreak(shiftDTO.getBreaks(), shift);
            this.loadBreaks(breaks);

            ArrayList<Allowance> allowances = transformService.transformAllowance(shiftDTO.getAllowances(), shift);
            this.loadAllowances(allowances);

            ArrayList<AwardInterpretation> awardInterpretations = transformService.transformAwardInterpretation(shiftDTO.getAwardInterpretations(), shift);
            this.loadAwardInterpretation(awardInterpretations);
        }
        return "The data was successfully supplied";
    }

    public void loadBreaks(ArrayList<Break> breaks){
        for (Break aBreak: breaks ){
            breakRepository.save(aBreak);
        }
    }

    public void loadAllowances(ArrayList<Allowance> allowances){
        for (Allowance allowance: allowances ){
            allowanceRepository.save(allowance);
        }
    }

    public void loadAwardInterpretation(ArrayList<AwardInterpretation> awardInterpretations){
        for (AwardInterpretation awardInterpretation: awardInterpretations ){
            awardInterpretationRepository.save(awardInterpretation);
        }
    }
}
