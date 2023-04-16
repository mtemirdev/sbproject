package com.mouflon.service.auth;


import com.mouflon.config.JwtUtils;
import com.mouflon.dto.auth.AuthRequest;
import com.mouflon.dto.auth.AuthResponse;
import com.mouflon.model.UserEntity;
import com.mouflon.model.enums.Role;
import com.mouflon.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    private final UserRepository userRepository;

    public AuthResponse authenticate(AuthRequest authRequest) {
        Authentication authentication;
        authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authRequest.getEmail(),
                authRequest.getPassword()
        ));
        Optional<UserEntity> userEmail = userRepository.findByEmail(authRequest.getEmail());
        Role role = userEmail.get().getRole();
        String generatedToken = jwtUtils.generateToken(authentication);
        System.out.println(generatedToken);
        return new AuthResponse(authRequest.getEmail(), role, generatedToken);
    }
}