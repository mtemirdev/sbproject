package com.mouflon.model;


import com.mouflon.model.enums.StudyFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "students")
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "student_id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Student(String firstName,
                   String lastName,
                   String email,
                   StudyFormat studyFormat,
                   Group group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studyFormat = studyFormat;
        this.group = group;
    }
}