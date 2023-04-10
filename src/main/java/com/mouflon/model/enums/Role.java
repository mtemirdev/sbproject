package com.mouflon.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ADMIN, USER, TEACHER, STUDENT;

    @Override
    public String getAuthority() {
        return name();
    }
}
