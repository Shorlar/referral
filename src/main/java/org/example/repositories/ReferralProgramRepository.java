package org.example.repositories;

import org.example.models.ReferralProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface ReferralProgramRepository extends JpaRepository<ReferralProgram, UUID> {

    @Modifying
    @Transactional
    @Query("UPDATE ReferralProgram rp SET rp.isActive = false WHERE rp.id <> :id AND rp.isActive = true")
    void deactivateOtherPrograms(UUID id);
}
