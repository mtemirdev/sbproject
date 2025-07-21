package com.mtemirdev.api;

import com.mtemirdev.dto.auth.AuthRequest;
import com.mtemirdev.dto.auth.AuthResponse;
import com.mtemirdev.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.security.PermitAll;

@RestController
@RequiredArgsConstructor
public class AuthApi {

    private final AuthService  authService;

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