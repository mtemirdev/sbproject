package com.mouflon.api;

import com.mouflon.dto.request.TeacherRequest;
import com.mouflon.dto.response.TeacherResponse;
import com.mouflon.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher")
public class TeacherApi {

    private final TeacherService teacherService;

    @PostMapping("/save_teacher")
    public String saveTeacher(@RequestBody TeacherRequest teacherRequest) {
        teacherService.registerTeacher(teacherRequest);
        return "Teacher was successfully saved!";
    }

    @GetMapping("/get_all_teachers")
    public List<TeacherResponse> getAllTeachers() {
        return teacherService.findAllTeachers();
    }

    @GetMapping("/get_teacher/{id}")
    public TeacherResponse getById(@PathVariable Long id) {
        return teacherService.findTeacherById(id);
    }

    @DeleteMapping("/delete_teacher/{id}")
    public String deleteById(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
        return "Teacher was successfully deleted!";
    }

    @PutMapping("/update_teacher/{id}")
    public String updateById(@PathVariable Long id, @RequestBody TeacherRequest teacherRequest) {
        teacherService.updateTeacher(id, teacherRequest);
        return "Teacher was successfully updated!";
    }
}