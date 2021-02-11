package com.leoncarraro.vaccination_control.controller;

import com.leoncarraro.vaccination_control.controller.util.URILocation;
import com.leoncarraro.vaccination_control.dto.UserRequest;
import com.leoncarraro.vaccination_control.dto.UserResponse;
import com.leoncarraro.vaccination_control.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserResponse> create(@RequestBody @Valid UserRequest userRequest) {
        UserResponse userResponse = userService.create(userRequest);

        return ResponseEntity.created(URILocation.get(userResponse.getId()))
                .body(userResponse);
    }

}
