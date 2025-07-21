package com.mtemirdev.dto.response;

import lombok.Data;

@Data
public class GroupResponse {

    private Long groupId;
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;
}