package com.leoncarraro.vaccination_control.service;

import com.leoncarraro.vaccination_control.dto.UserRequest;
import com.leoncarraro.vaccination_control.dto.UserResponse;
import com.leoncarraro.vaccination_control.model.User;
import com.leoncarraro.vaccination_control.repository.UserRepository;
import com.leoncarraro.vaccination_control.service.exception.ResourceAlreadyRegisteredException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponse create(UserRequest userRequest) {
        String cpf = userRequest.getCpf();
        String email = userRequest.getEmail();

        if (userRepository.existsByCpf(cpf)) {
            throw new ResourceAlreadyRegisteredException("" +
                    "User already registered with CPF " + cpf + "!");
        }
        if (userRepository.existsByEmail(email)) {
            throw new ResourceAlreadyRegisteredException("" +
                    "User already registered with email " + email + "!");
        }

        User user = new User(userRequest);
        user = userRepository.save(user);

        return new UserResponse(user);
    }

}
