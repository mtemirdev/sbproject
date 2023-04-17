package com.mouflon.model;

import com.mouflon.model.enums.Role;
import com.mouflon.model.enums.StudyFormat;
import lombok.*;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Student(String firstName,
                   String lastName,
                   String email,
                   String password,
                   Role role,
                   StudyFormat studyFormat,
                   Group group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.studyFormat = studyFormat;
        this.group = group;
    }
}