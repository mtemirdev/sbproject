package com.mouflon.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "courses")
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "course_id")
    private int id;
    @Column(name = "course_name")
    private String courseName;
    private String duration;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToOne(mappedBy = "course", cascade = CascadeType.REMOVE)
    private Teacher teacher;
    @ManyToMany(mappedBy = "courses", cascade = ALL)
    private List<Group> groups;

    public Course(String courseName,
                  String duration,
                  Company company,
                  Teacher teacher,
                  List<Group> groups) {
        this.courseName = courseName;
        this.duration = duration;
        this.company = company;
        this.teacher = teacher;
        this.groups = groups;
    }
}