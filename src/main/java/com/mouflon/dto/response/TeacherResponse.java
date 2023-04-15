package com.mouflon.dto.response;

import lombok.Data;

@Data
public class TeacherResponse {

    private Long id;

    private String firstname;

    private String lastname;

    private String email;
}
