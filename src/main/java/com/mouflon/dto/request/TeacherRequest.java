package com.mouflon.dto.request;

import lombok.Data;

@Data
public class TeacherRequest {

    private String firstname;

    private String lastname;

    private String email;

    private String password;
}