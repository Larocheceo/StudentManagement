package com.example.demo.database.entities;

import com.example.demo.database.entities.compositeIds.StudentCourseId;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class StudentCourse {

    @EmbeddedId
    private StudentCourseId studentCourseId = new StudentCourseId();

    @ManyToOne
    @MapsId("studentId")    //value is the name of the attribut in composite keys
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;
}
