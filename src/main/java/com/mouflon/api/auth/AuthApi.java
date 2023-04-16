package com.mouflon.api.auth;

import com.mouflon.dto.auth.AuthRequest;
import com.mouflon.dto.auth.AuthResponse;
import com.mouflon.dto.request.StudentRequest;
import com.mouflon.dto.request.TeacherRequest;
import com.mouflon.dto.request.UserRequest;
import com.mouflon.model.enums.Role;
import com.mouflon.service.UserService;
import com.mouflon.service.auth.AuthService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequiredArgsConstructor
public class AuthApi {

    private final AuthService authService;

    @PostMapping("/login")
    @PermitAll
    public AuthResponse authenticated(@RequestBody AuthRequest authRequest) {
        return authService.authenticate(authRequest);
    }

    @GetMapping("/get-user")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'STUDENT', 'TEACHER')")
    public String getString() {
        return "I'm User";
    }

    @GetMapping("/get-admin")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String getAdmin() {
        return "I'm Admin";
    }
}