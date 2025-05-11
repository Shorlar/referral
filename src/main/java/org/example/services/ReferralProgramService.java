package org.example.services;

import org.example.dtos.CreateReferralProgramDto;
import org.example.factories.ReferralProgramFactory;
import org.example.models.ReferralProgram;
import org.example.repositories.ReferralProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferralProgramService {

    @Autowired
    private ReferralProgramRepository referralProgramRepository;

    public ReferralProgram create(CreateReferralProgramDto createReferralProgramDto){
        ReferralProgram newProgram = ReferralProgramFactory.create(createReferralProgramDto);
        return referralProgramRepository.save(newProgram);
    }
}
