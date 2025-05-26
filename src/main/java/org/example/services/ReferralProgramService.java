package org.example.services;

import org.example.dtos.CreateReferralProgramDto;
import org.example.factories.ReferralProgramFactory;
import org.example.models.ReferralProgram;
import org.example.repositories.ReferralProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReferralProgramService {

    @Autowired
    private ReferralProgramRepository referralProgramRepository;

    public ReferralProgram create(CreateReferralProgramDto createReferralProgramDto){
        ReferralProgram newProgram = ReferralProgramFactory.create(createReferralProgramDto);
        return referralProgramRepository.save(newProgram);
    }

    public Page<ReferralProgram> getAllReferralPrograms(Pageable pageable) {
        return referralProgramRepository.findAll(pageable);
    }

    public ReferralProgram getReferralProgramById(UUID id) {
        return referralProgramRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Referral program not found with id: " + id));
    }
}
