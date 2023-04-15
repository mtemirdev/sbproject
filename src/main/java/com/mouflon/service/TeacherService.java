package com.mouflon.service;

import com.mouflon.dto.request.TeacherRequest;
import com.mouflon.dto.response.TeacherResponse;
import com.mouflon.model.Teacher;
import com.mouflon.model.enums.Role;
import com.mouflon.exception.CustomRuntimeException;
import com.mouflon.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    private final PasswordEncoder bCryptPasswordEncoder;

    private final ModelMapper modelMapper;

    public TeacherResponse registerTeacher(TeacherRequest teacherRequest) {
        if (teacherRepository.existsByEmail(teacherRequest.getEmail())) {
            throw new RuntimeException(
                    "This email is already have in!"
            );
        }
        var teacher = Teacher.builder()
                .firstname(teacherRequest.getFirstname())
                .lastname(teacherRequest.getLastname())
                .email(teacherRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(teacherRequest.getPassword()))
                .role(Role.TEACHER)
                .build();
        teacherRepository.save(teacher);
        return modelMapper.map(teacher, TeacherResponse.class);
    }

    public TeacherResponse findTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new CustomRuntimeException("Teacher not found with id: " + id));
        return modelMapper.map(teacher, TeacherResponse.class);
    }

    public List<TeacherResponse> findAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream()
                .map(teacher -> modelMapper.map(teacher, TeacherResponse.class))
                .collect(Collectors.toList());
    }

    public void deleteTeacherById(Long id) {
        boolean exists = teacherRepository.existsById(id);
        if (!exists) {
            throw new CustomRuntimeException("Teacher with id : " + id + "doesn't exist.");
        }
        teacherRepository.deleteById(id);
    }

    public TeacherResponse updateTeacher(Long id, TeacherRequest teacherRequest) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new CustomRuntimeException("Teacher not found with id " + id));
        modelMapper.map(teacherRequest, teacher);
        teacher = teacherRepository.save(teacher);
        return modelMapper.map(teacher, TeacherResponse.class);
    }
}