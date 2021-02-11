package com.leoncarraro.vaccination_control.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UserRequest {

    @NotBlank(message = "User name should not be null / empty!")
    private String name;

    @CPF(message = "User CPF should be valid!")
    private String cpf;

    @NotBlank(message = "User email should not be null / empty!")
    @Email(message = "User email should be valid!")
    private String email;

    @NotNull(message = "User birthdate should not be null / empty!")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    public String getName() { return name; }

    public String getCpf() { return cpf; }

    public String getEmail() { return email; }

    public LocalDate getBirthDate() { return birthDate; }

}
