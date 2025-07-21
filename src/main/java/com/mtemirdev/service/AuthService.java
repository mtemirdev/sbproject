package com.mtemirdev.service;

import com.mtemirdev.config.JwtUtils;
import com.mtemirdev.dto.auth.AuthRequest;
import com.mtemirdev.dto.auth.AuthResponse;
import com.mtemirdev.model.UserEntity;
import com.mtemirdev.model.enums.Role;
import com.mtemirdev.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
        Optional<UserEntity> user = userRepository.findByEmail(authRequest.getEmail());
        Role role = user.get().getRole();
        if (!BCrypt.checkpw(authRequest.getPassword(), user.get().getPassword())) {
            throw new BadCredentialsException("Invalid Password");
        }
        String generatedToken = jwtUtils.generateToken(authentication);
        System.out.println(generatedToken);
        return new AuthResponse(authRequest.getEmail(), role, generatedToken);
    }
}