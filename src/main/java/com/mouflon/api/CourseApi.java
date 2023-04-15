package com.mouflon.api;

import com.mouflon.dto.request.CourseRequest;
import com.mouflon.dto.response.CourseResponse;
import com.mouflon.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseApi {

    private final CourseService courseService;

    @PostMapping("/create_course")
    public String createCourse(@RequestBody CourseRequest courseRequest) {
        courseService.createCourse(courseRequest);
        return "Course successfully created!";
    }

    @GetMapping("/get_all_courses")
    public List<CourseResponse> getAllCourses() {
        return courseService.findAllCourses();
    }

    @GetMapping("/get_course/{id}")
    public CourseResponse getById(@PathVariable Long id) {
        return courseService.findCourseById(id);
    }

    @DeleteMapping("/delete_course/{id}")
    public String deleteById(@PathVariable Long id) {
        courseService.deleteCourseById(id);
        return "Course successfully deleted!";
    }

    @PutMapping("/update_course/{id}")
    public String updateById(@PathVariable Long id, @RequestBody CourseRequest courseRequest) {
        courseService.updateCourse(id, courseRequest);
        return "Course successfully updated!";
    }
}
