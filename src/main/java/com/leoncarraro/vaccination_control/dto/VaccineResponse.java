package com.leoncarraro.vaccination_control.dto;

import com.leoncarraro.vaccination_control.model.Vaccine;

public class VaccineResponse {

    private final Long id;
    private final String name;

    public VaccineResponse(Vaccine vaccine) {
        id = vaccine.getId();
        name = vaccine.getName();
    }

    public Long getId() { return id; }

    public String getName() { return name; }

}
