package com.leoncarraro.vaccination_control.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.leoncarraro.vaccination_control.model.User;

import java.time.LocalDate;

public class UserResponse {

    private final Long id;
    private final String name;
    private final String cpf;
    private final String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private final LocalDate birthDate;

    public UserResponse(User user) {
        id = user.getId();
        name = user.getName();
        cpf = user.getCpf();
        email = user.getEmail();
        birthDate = user.getBirthDate();
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public String getCpf() { return cpf; }

    public String getEmail() { return email; }

    public LocalDate getBirthDate() { return birthDate; }

}
