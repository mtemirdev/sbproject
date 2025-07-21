package com.mtemirdev.api;

import com.mtemirdev.dto.request.TeacherRequest;
import com.mtemirdev.dto.response.TeacherResponse;
import com.mtemirdev.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher")
public class TeacherApi {

    private final TeacherService teacherService;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/save_teacher")
    public String saveTeacher(@RequestBody TeacherRequest teacherRequest) {
        teacherService.registerTeacher(teacherRequest);
        return "Teacher was successfully saved!";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    @GetMapping("/get_all_teachers")
    public List<TeacherResponse> getAllTeachers() {
        return teacherService.findAllTeachers();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    @GetMapping("/get_teacher/{id}")
    public TeacherResponse getById(@PathVariable Long id) {
        return teacherService.findTeacherById(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    @DeleteMapping("/delete_teacher/{id}")
    public String deleteById(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
        return "Teacher was successfully deleted!";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    @PutMapping("/update_teacher/{id}")
    public String updateById(@PathVariable Long id, @RequestBody TeacherRequest teacherRequest) {
        teacherService.updateTeacher(id, teacherRequest);
        return "Teacher was successfully updated!";
    }
}