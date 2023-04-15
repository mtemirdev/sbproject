package com.mouflon.model;


import com.mouflon.model.enums.Role;
import com.mouflon.model.enums.StudyFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(name = "student_id")
    private Long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Student(String firstname,
                   String lastname,
                   String email,
                   String password,
                   Role role,
                   StudyFormat studyFormat,
                   Group group) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.studyFormat = studyFormat;
        this.group = group;
    }
}