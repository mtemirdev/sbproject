package com.mouflon.service;

import com.mouflon.dto.request.UserRequest;
import com.mouflon.dto.response.UserResponse;
import com.mouflon.mapper.UserMapper;
import com.mouflon.model.UserEntity;
import com.mouflon.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final ModelMapper modelMapper;

    public UserResponse registerUser(UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new RuntimeException("This email is already have in!");
        }
        UserEntity savedUser = userRepository.save(userMapper.toUser(userRequest));
        return modelMapper.map(savedUser, UserResponse.class);
    }
}