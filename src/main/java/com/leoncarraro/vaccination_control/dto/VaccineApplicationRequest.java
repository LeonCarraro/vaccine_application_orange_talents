package com.leoncarraro.vaccination_control.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class VaccineApplicationRequest {

    @NotNull(message = "Vaccine is required!")
    private Long vaccineId;

    @NotNull(message = "User is required!")
    private Long userId;

    @NotNull(message = "Vaccine application date should not be null / empty!")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate applicationDate;

    public Long getVaccineId() { return vaccineId; }

    public Long getUserId() { return userId; }

    public LocalDate getApplicationDate() { return applicationDate; }

}
