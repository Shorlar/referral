package org.example.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateReferralStatusDto {

    @NotNull(message = "isActive field is required")
    private Boolean isActive;
}
