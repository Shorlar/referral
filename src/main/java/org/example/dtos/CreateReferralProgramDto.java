package org.example.dtos;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Data
public class CreateReferralProgramDto {

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be less than 100 characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(max = 1000, message = "Description must be less than 1000 characters")
    private String description;


    @NotBlank(message = "Start date is required")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Start date must be in the format YYYY-MM-DD")
    private String startDate;

    @NotBlank(message = "End date is required")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "End date must be in the format YYYY-MM-DD")
    private String endDate;
}
