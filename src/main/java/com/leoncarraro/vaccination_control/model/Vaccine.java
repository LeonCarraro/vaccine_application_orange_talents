package com.leoncarraro.vaccination_control.model;

import com.leoncarraro.vaccination_control.dto.VaccineRequest;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_vaccine")
public class Vaccine implements Serializable {
    private static final long serialVersionUID = -3675662489000088054L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    public Vaccine() {}

    public Vaccine(VaccineRequest vaccineRequest) {
        id = null;
        name = vaccineRequest.getName();
    }

    public Long getId() { return id; }

    public String getName() { return name; }

}
