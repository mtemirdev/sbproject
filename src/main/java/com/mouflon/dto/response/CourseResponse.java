package com.mouflon.dto.response;

import lombok.Data;

@Data
public class CourseResponse {

    private Long courseId;
    private String courseName;
    private String duration;
}
