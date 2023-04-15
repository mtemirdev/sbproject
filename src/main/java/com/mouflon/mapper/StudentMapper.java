package com.mouflon.mapper;

import com.mouflon.dto.request.StudentRequest;
import com.mouflon.model.Student;
import com.mouflon.model.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentMapper {

    private final PasswordEncoder bCryptPasswordEncoder;

    public Student toStudent(StudentRequest studentRequest) {
        return Student.builder()
                .firstname(studentRequest.getFirstname())
                .lastname(studentRequest.getLastname())
                .studyFormat(studentRequest.getStudyFormat())
                .email(studentRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(studentRequest.getPassword()))
                .role(Role.STUDENT)
                .build();
    }
}
