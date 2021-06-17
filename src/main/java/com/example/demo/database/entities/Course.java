package com.example.demo.database.entities;



import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course", uniqueConstraints = {
        @UniqueConstraint(name = "unique_course_name", columnNames = "course_name")})
@Data
public class Course extends BaseEntity{

    @Column(name = "course_name", unique = true , nullable = false)
    private String courseName;
    private String faculty;

    private int credits;

    @ToString.Exclude
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentCourse> students = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ProfessorCourse> professorCourseList = new ArrayList<>();
}
