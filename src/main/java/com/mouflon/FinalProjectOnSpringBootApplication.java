package com.mouflon;

import com.mouflon.entity.*;
import com.mouflon.entity.enums.Role;
import com.mouflon.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class FinalProjectOnSpringBootApplication {

    private final UserRepository userRepository;

    private final PasswordEncoder pass;

    public static void main(String[] args) {
        SpringApplication.run(FinalProjectOnSpringBootApplication.class, args);
    }

    @PostConstruct
    public void init() {

        UserEntity user1 = new UserEntity();
        user1.setFirstname("Marlen");
        user1.setLastname("Temirbaev");
        user1.setEmail("marlen@gmail.com");
        user1.setRole(Role.ADMIN);
        user1.setPassword(pass.encode("marlen"));

        UserEntity user2 = new UserEntity();
        user2.setFirstname("Dastan");
        user2.setLastname("Abdullaev");
        user2.setEmail("dosya@gmail.com");
        user2.setRole(Role.USER);
        user2.setPassword(pass.encode("dosya"));

        userRepository.save(user1);
        userRepository.save(user2);
    }
}
