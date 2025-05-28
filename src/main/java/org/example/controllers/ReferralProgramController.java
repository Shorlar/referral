package org.example.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.example.dtos.CreateReferralProgramDto;
import org.example.dtos.UpdateReferralStatusDto;
import org.example.models.ReferralProgram;
import org.example.services.ReferralProgramService;
import org.example.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<ApiResponse<Page<ReferralProgram>>> getReferralPrograms(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Page<ReferralProgram> referralPrograms = referralProgramService.getAllReferralPrograms(PageRequest.of(page, size));

        ApiResponse<Page<ReferralProgram>> response = new ApiResponse<Page<ReferralProgram>>(
                "Referral programs retrieved successfully",
                referralPrograms
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ReferralProgram>> getReferralProgramById(@PathVariable UUID id) {
        ReferralProgram referralProgram = referralProgramService.getReferralProgramById(id);

        ApiResponse<ReferralProgram> response = new ApiResponse<>(
                "Referral program retrieved successfully",
                referralProgram
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ApiResponse<ReferralProgram>> toggleReferralProgramStatus(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateReferralStatusDto updateReferralStatusDto
    ) {
        ReferralProgram updatedProgram = referralProgramService.toggleReferralProgramStatus(id, updateReferralStatusDto);

        ApiResponse<ReferralProgram> response = new ApiResponse<>(
                "Referral program status updated successfully",
                updatedProgram
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
