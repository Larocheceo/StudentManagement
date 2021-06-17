package com.example.demo.database.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "professor", uniqueConstraints = {
        @UniqueConstraint(name = "unique_prof_email", columnNames = "prof_email"),
        @UniqueConstraint(name = "unique_prof_matricule" , columnNames = "prof_matricule")
})
public class Professor extends BaseEntity{

    @Column(name = "prof_first_name")
    private String profFirstname;
    @Column(name = "prof_last_name")
    private String profLastName;
    @Column(name = "prof_email")
    private String profEmail;
    @Column(name = "prof_matricule")
    private String profMatricule;

    @ToString.Exclude
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ProfessorCourse> professorCourseList = new ArrayList<>();





}
