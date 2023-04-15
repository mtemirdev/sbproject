package com.mouflon;

import com.mouflon.model.*;
import com.mouflon.model.enums.Role;
import com.mouflon.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
        userRepository.save(user1);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("I'm tired...");
    }
}