package com.example.demo.database.entities;

import com.example.demo.database.entities.compositeIds.ProfessorCourseId;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "professor_course")
public class ProfessorCourse {

    @EmbeddedId
    private ProfessorCourseId professorCourseId = new ProfessorCourseId();

    @ManyToOne
    @MapsId("professorId")
    @JoinColumn(name ="professor_id")
    private Professor professor;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name ="course_id")
    private Course course;

}
