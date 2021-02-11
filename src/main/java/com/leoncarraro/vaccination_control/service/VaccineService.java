package com.leoncarraro.vaccination_control.service;

import com.leoncarraro.vaccination_control.dto.VaccineRequest;
import com.leoncarraro.vaccination_control.dto.VaccineResponse;
import com.leoncarraro.vaccination_control.model.Vaccine;
import com.leoncarraro.vaccination_control.repository.VaccineRepository;
import com.leoncarraro.vaccination_control.service.exception.ResourceAlreadyRegisteredException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VaccineService {

    private final VaccineRepository vaccineRepository;

    public VaccineService(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @Transactional
    public VaccineResponse create(VaccineRequest vaccineRequest) {
        String name = vaccineRequest.getName();

        if (vaccineRepository.existsByName(name)) {
            throw new ResourceAlreadyRegisteredException(
                    "Vaccine already registered with name " + name + "!");
        }

        Vaccine vaccine = new Vaccine(vaccineRequest);
        vaccine = vaccineRepository.save(vaccine);

        return new VaccineResponse(vaccine);
    }

}
