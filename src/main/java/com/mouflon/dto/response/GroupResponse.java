package com.mouflon.dto.response;

import lombok.Data;

@Data
public class GroupResponse {

    private Long id;

    private String groupName;

    private String dateOfStart;

    private String dateOfFinish;
}
