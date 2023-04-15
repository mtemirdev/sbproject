package com.mouflon.service;

import com.mouflon.dto.request.StudentRequest;
import com.mouflon.dto.request.TeacherRequest;
import com.mouflon.dto.request.UserRequest;
import com.mouflon.dto.response.StudentResponse;
import com.mouflon.dto.response.TeacherResponse;
import com.mouflon.dto.response.UserResponse;
import com.mouflon.mapper.StudentMapper;
import com.mouflon.mapper.TeacherMapper;
import com.mouflon.mapper.UserMapper;
import com.mouflon.model.Student;
import com.mouflon.model.Teacher;
import com.mouflon.model.UserEntity;
import com.mouflon.model.enums.Role;
import com.mouflon.repository.StudentRepository;
import com.mouflon.repository.TeacherRepository;
import com.mouflon.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final StudentRepository studentRepository;

    private final TeacherRepository teacherRepository;

    private final UserMapper userMapper;

    private final StudentMapper studentMapper;

    private final TeacherMapper teacherMapper;

    private final ModelMapper modelMapper;

    public UserResponse registerUser(UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new RuntimeException("This email is already have in!");
        }
        UserEntity savedUser = userRepository.save(userMapper.toUser(userRequest));
        return modelMapper.map(savedUser, UserResponse.class);
    }

    public StudentResponse registerStudent(StudentRequest studentRequest) {
        if (studentRepository.existsByEmail(studentRequest.getEmail())) {
            throw new RuntimeException("This email is already have in!");
        }
        userRepository.save(userMapper.toUser(studentRequest));
        Student savedStudent = studentRepository.save(studentMapper.toStudent(studentRequest));
        return modelMapper.map(savedStudent, StudentResponse.class);
    }

    public TeacherResponse registerTeacher(TeacherRequest teacherRequest) {
        if (teacherRepository.existsByEmail(teacherRequest.getEmail())) {
            throw new RuntimeException("This email is already have in!");
        }
        userRepository.save(userMapper.toUser(teacherRequest));
        Teacher savedTeacher = teacherRepository.save(teacherMapper.toTeacher(teacherRequest));
        return modelMapper.map(savedTeacher, TeacherResponse.class);
    }
}