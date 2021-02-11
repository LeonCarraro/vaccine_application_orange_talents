package com.leoncarraro.vaccination_control.model;

import com.leoncarraro.vaccination_control.dto.VaccineApplicationRequest;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_vaccine_application")
public class VaccineApplication implements Serializable {
    private static final long serialVersionUID = -7613362307574447475L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vaccine_id", nullable = false)
    private Vaccine vaccine;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(name = "application_date", nullable = false)
    private LocalDate applicationDate;

    public VaccineApplication() {}

    public VaccineApplication(VaccineApplicationRequest vaccineApplicationRequest,
                              Vaccine vaccine, User user) {
        id = null;
        this.vaccine = vaccine;
        this.user = user;
        applicationDate = vaccineApplicationRequest.getApplicationDate();
    }

    public Long getId() { return id; }

    public Vaccine getVaccine() { return vaccine; }

    public User getUser() { return user; }

    public LocalDate getApplicationDate() { return applicationDate; }

}
