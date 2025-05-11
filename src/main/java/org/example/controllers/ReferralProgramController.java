package org.example.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.example.dtos.CreateReferralProgramDto;
import org.example.models.ReferralProgram;
import org.example.services.ReferralProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/referral-programs")
public class ReferralProgramController {

    @Autowired
    ObjectMapper mapper;
    @Autowired
    private ReferralProgramService referralProgramService;

    @PostMapping
    public ResponseEntity<ReferralProgram> createReferralProgram(@Valid @RequestBody CreateReferralProgramDto createReferralProgramDto){
        ReferralProgram newProgram = referralProgramService.create(createReferralProgramDto);
        return new ResponseEntity<>(newProgram, HttpStatus.CREATED);
    }
}
