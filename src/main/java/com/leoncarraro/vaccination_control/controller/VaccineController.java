package com.leoncarraro.vaccination_control.controller;

import com.leoncarraro.vaccination_control.controller.util.URILocation;
import com.leoncarraro.vaccination_control.dto.VaccineRequest;
import com.leoncarraro.vaccination_control.dto.VaccineResponse;
import com.leoncarraro.vaccination_control.service.VaccineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/vaccines")
public class VaccineController {

    private final VaccineService vaccineService;

    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<VaccineResponse> create(
            @RequestBody @Valid VaccineRequest vaccineRequest) {
        VaccineResponse vaccineResponse = vaccineService.create(vaccineRequest);

        return ResponseEntity.created(URILocation.get(vaccineResponse.getId()))
                .body(vaccineResponse);
    }

}
