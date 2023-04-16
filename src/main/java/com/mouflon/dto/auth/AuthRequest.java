package com.mouflon.dto.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mouflon.model.enums.Role;
import lombok.Data;

@Data
public class AuthRequest {

    private String email;

    @JsonIgnore
    private Role role;

    private String password;
}
