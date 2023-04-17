package com.mouflon.mapper;

import com.mouflon.dto.request.TeacherRequest;
import com.mouflon.model.Teacher;
import com.mouflon.model.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherMapper {

    private final PasswordEncoder bCryptPasswordEncoder;

    public Teacher toTeacher(TeacherRequest teacherRequest) {
        return Teacher.builder()
                .firstName(teacherRequest.getFirstName())
                .lastName(teacherRequest.getLastName())
                .email(teacherRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(teacherRequest.getPassword()))
                .role(Role.TEACHER)
                .build();
    }
}