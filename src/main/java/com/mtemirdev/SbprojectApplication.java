package com.mtemirdev;

import com.mtemirdev.model.*;
import com.mtemirdev.model.enums.Role;
import com.mtemirdev.repository.UserRepository;
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
public class SbprojectApplication {

    private final UserRepository userRepository;
    private final PasswordEncoder pass;

    public static void main(String[] args) {
        SpringApplication.run(SbprojectApplication.class, args);
    }

    @PostConstruct
    public void init() {
        UserEntity user1 = new UserEntity();
        user1.setFirstName("Marlen");
        user1.setLastName("Temirbaev");
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