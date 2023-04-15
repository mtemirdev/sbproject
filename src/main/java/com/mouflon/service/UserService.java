package com.mouflon.service;

import com.mouflon.dto.request.UserRequest;


import com.mouflon.dto.response.UserResponse;
import com.mouflon.entity.UserEntity;
import com.mouflon.entity.enums.Role;
import com.mouflon.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final PasswordEncoder bCryptPasswordEncoder;

    public UserResponse register(UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new RuntimeException(
                    "This email is already have in!"
            );
        }
        var user = UserEntity.builder()
                .firstname((userRequest.getFirstname()))
                .lastname(userRequest.getLastname())
                .email(userRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(userRequest.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        return modelMapper.map(user, UserResponse.class);
    }
}