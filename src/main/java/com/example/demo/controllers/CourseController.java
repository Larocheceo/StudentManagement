package com.example.demo.controllers;

import com.example.demo.database.entities.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String viewAllCourses( Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "course/all_courses";
    }

    @GetMapping("/add-course")
    public String addNewCourse(Model model){
        Course course = new Course();
        model.addAttribute("course", course);
        return "course/new_course";
    }

    @PostMapping
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.addNewCourse(course);
        return "redirect:";

    }


}
