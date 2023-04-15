package com.mouflon.dto.request;

import com.mouflon.model.enums.StudyFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private StudyFormat studyFormat;
}
