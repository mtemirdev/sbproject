package com.mouflon.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long courseId;
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