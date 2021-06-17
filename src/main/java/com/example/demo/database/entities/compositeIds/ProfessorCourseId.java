package com.example.demo.database.entities.compositeIds;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProfessorCourseId implements Serializable {

    @Column(name = "professor_id")
    private Long professorId;
    @Column(name = "course_id")
    private Long courseId;
}
