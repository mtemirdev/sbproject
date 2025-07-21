package com.mtemirdev.model;

import com.mtemirdev.model.enums.Role;
import lombok.*;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long teacherId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Teacher(String firstName,
                   String lastName,
                   String email,
                   String password,
                   Role role,
                   Course course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.course = course;
    }
}