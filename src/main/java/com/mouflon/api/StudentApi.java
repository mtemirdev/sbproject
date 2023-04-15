package com.mouflon.api;

import com.mouflon.dto.request.StudentRequest;
import com.mouflon.dto.response.StudentResponse;
import com.mouflon.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentApi {

    private final StudentService studentService;

    @PostMapping("/save_student")
    public String saveStudent(@RequestBody StudentRequest studentRequest) {
        studentService.registerStudent(studentRequest);
        return "Student was successfully saved!";
    }

    @GetMapping("/get_all_students")
    public List<StudentResponse> getAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/get_student/{id}")
    public StudentResponse getById(@PathVariable Long id) {
        return studentService.findStudentById(id);
    }

    @DeleteMapping("/delete_student/{id}")
    public String deleteById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "Student was successfully deleted!";
    }

    @PutMapping("/update_student/{id}")
    public String updateById(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
        studentService.updateStudent(id, studentRequest);
        return "Student was successfully updated!";
    }
}
