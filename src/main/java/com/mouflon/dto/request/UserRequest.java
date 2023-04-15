package com.mouflon.dto.request;

import com.mouflon.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String firstname;

    private String lastname;

    private String email;

    private Role role;

    private String password;
}
