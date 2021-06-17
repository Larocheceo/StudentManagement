package com.example.demo.database.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "mentor")
public class Mentor extends BaseEntity{

    @Column(name = "mentor_firstname", nullable = false)
    private String mentorFirstname;
    @Column(name = "mentor_lastname", nullable = false)
    private String mentorLastName;
    @Column(name = "mentor_job")
    private String Job;

    @ToString.Exclude
    @OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;


}
