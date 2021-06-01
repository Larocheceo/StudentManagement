package com.example.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


//@RequestMapping(path = "api/v1/student")
@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired  // Pour eviter de creer un nouveau student service avec new dans le constructeur.
    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping("/students") // On met le get mapping sur la fonction qui doit retourner une nformation du serveur.
    public String getStudents(Model model){
        model.addAttribute("students", studentService.getStudents());
        return "students";
    }

    /**@PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
     */
    @GetMapping("/students/new")
    public String createStudent(Model model){

        //create Student
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";

    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model){

        //get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(student.getId());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());

        // sae student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";

    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }




    /**@DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);

    }*/



}
