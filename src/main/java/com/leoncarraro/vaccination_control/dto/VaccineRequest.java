package com.leoncarraro.vaccination_control.dto;

import javax.validation.constraints.NotBlank;

public class VaccineRequest {

    @NotBlank(message = "Vaccine name should not be null / empty!")
    private String name;

    public String getName() { return name; }

}
