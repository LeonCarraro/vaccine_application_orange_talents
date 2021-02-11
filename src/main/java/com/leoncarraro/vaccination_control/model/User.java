package com.leoncarraro.vaccination_control.model;

import com.leoncarraro.vaccination_control.dto.UserRequest;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = 412954140533999186L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    public User() {
    }

    public User(UserRequest userRequest) {
        id = null;
        cpf = userRequest.getCpf();
        email = userRequest.getEmail();
        birthDate = userRequest.getBirthDate();
        name = userRequest.getName();
    }

    public Long getId() { return id; }

    public String getCpf() { return cpf; }

    public String getEmail() { return email; }

    public LocalDate getBirthDate() { return birthDate; }

    public String getName() { return name; }

}
