package com.leoncarraro.vaccination_control.service;

import com.leoncarraro.vaccination_control.dto.VaccineApplicationRequest;
import com.leoncarraro.vaccination_control.dto.VaccineApplicationResponse;
import com.leoncarraro.vaccination_control.model.User;
import com.leoncarraro.vaccination_control.model.Vaccine;
import com.leoncarraro.vaccination_control.model.VaccineApplication;
import com.leoncarraro.vaccination_control.repository.UserRepository;
import com.leoncarraro.vaccination_control.repository.VaccineApplicationRepository;
import com.leoncarraro.vaccination_control.repository.VaccineRepository;
import com.leoncarraro.vaccination_control.service.exception.BadRequestException;
import com.leoncarraro.vaccination_control.service.exception.BusinessException;
import com.leoncarraro.vaccination_control.service.exception.ResourceAlreadyRegisteredException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class VaccineApplicationService {

    private final VaccineApplicationRepository vaccineApplicationRepository;
    private final UserRepository userRepository;
    private final VaccineRepository vaccineRepository;

    public VaccineApplicationService(VaccineApplicationRepository vaccineApplicationRepository,
                                     UserRepository userRepository,
                                     VaccineRepository vaccineRepository) {
        this.vaccineApplicationRepository = vaccineApplicationRepository;
        this.userRepository = userRepository;
        this.vaccineRepository = vaccineRepository;
    }

    @Transactional
    public VaccineApplicationResponse create(VaccineApplicationRequest vaccineApplicationRequest) {
        Long userId = vaccineApplicationRequest.getUserId();
        Long vaccineId = vaccineApplicationRequest.getVaccineId();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found! ID: " + userId));
        Vaccine vaccine = vaccineRepository.findById(vaccineId)
                .orElseThrow(() -> new BadRequestException("Vaccine not found! ID: " + vaccineId));

        if (vaccineApplicationRepository.existsByUser(user)) {
            throw new ResourceAlreadyRegisteredException(
                    "Vaccine application already registered for user " + user.getName() + "!");
        }

        LocalDate applicationDate = vaccineApplicationRequest.getApplicationDate();
        LocalDate userBirthdate = user.getBirthDate();
        if (applicationDate.isBefore(userBirthdate)) {
            throw new BusinessException(
                    "Are you sure you entered the application date of the vaccine correctly? " +
                    "(vaccine application date is before than the user birthdate)");
        }

        VaccineApplication vaccineApplication = new VaccineApplication(
                vaccineApplicationRequest, vaccine, user);

        vaccineApplication = vaccineApplicationRepository.save(vaccineApplication);

        return new VaccineApplicationResponse(vaccineApplication);
    }

}
