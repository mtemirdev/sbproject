package com.mouflon.entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    USER,
    ADMIN,
    TEACHER,
    STUDENT;

    @Override
    public String getAuthority() {
        return name();
    }
}
