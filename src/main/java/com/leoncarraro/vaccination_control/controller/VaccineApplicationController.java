package com.leoncarraro.vaccination_control.controller;

import com.leoncarraro.vaccination_control.controller.util.URILocation;
import com.leoncarraro.vaccination_control.dto.VaccineApplicationRequest;
import com.leoncarraro.vaccination_control.dto.VaccineApplicationResponse;
import com.leoncarraro.vaccination_control.service.VaccineApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/vaccine-applications")
public class VaccineApplicationController {

    private final VaccineApplicationService vaccineApplicationService;

    public VaccineApplicationController(VaccineApplicationService vaccineApplicationService) {
        this.vaccineApplicationService = vaccineApplicationService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<VaccineApplicationResponse> create(
            @RequestBody @Valid VaccineApplicationRequest vaccineApplicationRequest) {

        VaccineApplicationResponse vaccineApplicationResponse = vaccineApplicationService
                .create(vaccineApplicationRequest);

        return ResponseEntity.created(URILocation.get(vaccineApplicationResponse.getId()))
                .body(vaccineApplicationResponse);
    }

}
