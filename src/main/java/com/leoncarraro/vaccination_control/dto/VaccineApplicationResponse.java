package com.leoncarraro.vaccination_control.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.leoncarraro.vaccination_control.model.User;
import com.leoncarraro.vaccination_control.model.Vaccine;
import com.leoncarraro.vaccination_control.model.VaccineApplication;

import java.time.LocalDate;

public class VaccineApplicationResponse {

    private final Long id;
    private final User user;
    private final Vaccine vaccine;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private final LocalDate applicationDate;

    public VaccineApplicationResponse(VaccineApplication vaccineApplication) {
        id = vaccineApplication.getId();
        user = vaccineApplication.getUser();
        vaccine = vaccineApplication.getVaccine();
        applicationDate = vaccineApplication.getApplicationDate();
    }

    public Long getId() { return id; }

    public User getUser() { return user; }

    public Vaccine getVaccine() { return vaccine; }

    public LocalDate getApplicationDate() { return applicationDate; }

}
