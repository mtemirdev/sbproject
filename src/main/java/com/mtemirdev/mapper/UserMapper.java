package com.mtemirdev.mapper;

import com.mtemirdev.dto.request.StudentRequest;
import com.mtemirdev.dto.request.TeacherRequest;
import com.mtemirdev.dto.request.UserRequest;
import com.mtemirdev.model.UserEntity;
import com.mtemirdev.model.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder bCryptPasswordEncoder;

    public UserEntity toUser(UserRequest userRequest) {
        return UserEntity.builder()
                .firstName((userRequest.getFirstName()))
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(userRequest.getPassword()))
                .build();
    }

    public UserEntity toUser(StudentRequest studentRequest) {
        return UserEntity.builder()
                .firstName((studentRequest.getFirstName()))
                .lastName(studentRequest.getLastName())
                .email(studentRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(studentRequest.getPassword()))
                .role(Role.STUDENT)
                .build();
    }

    public UserEntity toUser(TeacherRequest teacherRequest) {
        return UserEntity.builder()
                .firstName((teacherRequest.getFirstName()))
                .lastName(teacherRequest.getLastName())
                .email(teacherRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(teacherRequest.getPassword()))
                .role(Role.TEACHER)
                .build();
    }
}