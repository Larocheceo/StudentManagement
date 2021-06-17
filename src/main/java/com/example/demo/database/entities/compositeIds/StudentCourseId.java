package com.example.demo.database.entities.compositeIds;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseId implements Serializable {
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "course_id")
    private Long courseId;
}
