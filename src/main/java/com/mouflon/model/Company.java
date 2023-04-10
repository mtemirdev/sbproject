package com.mouflon.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "company_id")
    private int id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "located_country")
    private String locatedCountry;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courses;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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