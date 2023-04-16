package com.mouflon.dto.auth;

import com.mouflon.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class AuthResponse {

    private String email;

    private Role role;

    private String jwt;
}