package com.example.demo.service;

import com.example.demo.database.entities.Student;
import com.example.demo.database.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component  // To reference a bean of studentcontroller
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {
        return studentRepository.findAll();

    }

    /**public void addNewStudent(Student student) {
       Optional<Student>  studentOptional = studentRepository
               .findStudentByEmail(student.getEmail());
       if (studentOptional.isPresent()){
          throw new IllegalStateException("email taken");
       }
        studentRepository.save(student);
    }
    */
    public Student saveStudent(Student student){
       return studentRepository.save(student);
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).get();
    }

    public Student updateStudent(Student student){
        return  studentRepository.save(student);
    }



    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException(
                    "student with id " + studentId + "does not exists");
        }
        studentRepository.deleteById(studentId);
    }

   /** @Transactional
    public void updateStudent(
            Long studentId,
            String name,
            String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + " does not exist"));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository
                    .findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("email already taken");
            }
            student.setEmail(email);
        }
    }*/
}
