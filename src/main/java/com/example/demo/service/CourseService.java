package com.example.demo.service;

import com.example.demo.database.entities.Course;
import com.example.demo.database.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses;
    }

    public void addNewCourse(Course course) {
        courseRepository.save(course);
    }
}

