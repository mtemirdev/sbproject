package com.mouflon.mapper;

import com.mouflon.dto.request.StudentRequest;
import com.mouflon.dto.request.TeacherRequest;
import com.mouflon.dto.request.UserRequest;
import com.mouflon.model.UserEntity;
import com.mouflon.model.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder bCryptPasswordEncoder;

    public UserEntity toUser(UserRequest userRequest) {
        return UserEntity.builder()
                .firstname((userRequest.getFirstname()))
                .lastname(userRequest.getLastname())
                .email(userRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(userRequest.getPassword()))
                .build();
    }

    public UserEntity toUser(StudentRequest studentRequest) {
        return UserEntity.builder()
                .firstname((studentRequest.getFirstname()))
                .lastname(studentRequest.getLastname())
                .email(studentRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(studentRequest.getPassword()))
                .role(Role.STUDENT)
                .build();
    }

    public UserEntity toUser(TeacherRequest teacherRequest) {
        return UserEntity.builder()
                .firstname((teacherRequest.getFirstname()))
                .lastname(teacherRequest.getLastname())
                .email(teacherRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(teacherRequest.getPassword()))
                .role(Role.TEACHER)
                .build();
    }
}