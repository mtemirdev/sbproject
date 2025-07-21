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
public class Company {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long companyId;
    private String companyName;
    private String locatedCountry;
    @OneToMany(
            mappedBy = "company",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Course> courses;
    @OneToMany(
            mappedBy = "company",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Group> groups;

    public Company(String companyName,
                   String locatedCountry,
                   List<Course> courses,
                   List<Group> groups) {
        this.companyName = companyName;
        this.locatedCountry = locatedCountry;
        this.courses = courses;
        this.groups = groups;
    }
}