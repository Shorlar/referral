package org.example.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.example.dtos.CreateReferralProgramDto;
import org.example.models.ReferralProgram;
import org.example.services.ReferralProgramService;
import org.example.utils.ApiResponse;
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
    private ReferralProgramService referralProgramService;

    @PostMapping
    public ResponseEntity<ApiResponse<ReferralProgram>> createReferralProgram(@Valid @RequestBody CreateReferralProgramDto createReferralProgramDto){
        ReferralProgram newProgram = referralProgramService.create(createReferralProgramDto);

        ApiResponse<ReferralProgram> response = new ApiResponse<>(
                "Referral program created successfully",
                newProgram
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
