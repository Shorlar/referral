package org.example.factories;

import org.example.dtos.CreateReferralProgramDto;
import org.example.models.ReferralProgram;

public class ReferralProgramFactory {

    public static ReferralProgram create(CreateReferralProgramDto createReferralProgramDto){
        ReferralProgram program = new ReferralProgram();
        program.setName(createReferralProgramDto.getName());
        program.setDescription(createReferralProgramDto.getDescription());
        program.setStartDate(java.sql.Date.valueOf(createReferralProgramDto.getStartDate()));
        program.setEndDate(java.sql.Date.valueOf(createReferralProgramDto.getEndDate()));

        return program;
    }
}
