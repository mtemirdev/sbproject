package com.mtemirdev.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long groupId;
    private String groupName;
    @Column(name = "start")
    private String dateOfStart;
    @Column(name = "finish")
    private String dateOfFinish;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToMany(
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Student> students;
    @ManyToMany
    @JoinTable(
            name = "groups_courses",
            joinColumns = {@JoinColumn(name = "group_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private List<Course> courses;

    public Group(String groupName,
                 String dateOfStart,
                 String dateOfFinish,
                 Company company,
                 List<Student> students,
                 List<Course> courses) {
        this.groupName = groupName;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
        this.company = company;
        this.students = students;
        this.courses = courses;
    }
}