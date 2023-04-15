package com.mouflon.dto.response;

import com.mouflon.model.enums.StudyFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private StudyFormat studyFormat;
}
