package com.java.student.sms.controllers;

import com.java.student.sms.model.entity.Student;
import com.java.student.sms.model.response.StudentWithParents;
import com.java.student.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/api/hello")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/api/student/all-students")
    public ResponseEntity<?> findAllStudentsWithClass() {
        return ResponseEntity.ok().body(studentRepository.findAll());
    }

    @GetMapping("/api/students/{searchInput}")
    public ResponseEntity<?> findStudentWithSearchInput(@PathVariable("searchInput") String searchInput) {
        return ResponseEntity.ok().body(studentRepository.findByFirstNameContaining(searchInput));
    }

    /**
     * @return List all students with parent information.
     */
    @GetMapping("/api/students/parents")
    public ResponseEntity<?> findStudentWithParents() {
        List<Student> students = studentRepository.findAll();
        ArrayList<StudentWithParents> studentWithParentList = new ArrayList<>();

        students.forEach(student -> {
            StudentWithParents studentWithParents = StudentWithParents.builder()
                    .rollNumber(student.getRollNumber())
                    .firstName(student.getFirstName())
                    .lastName(student.getLastName())
                    .dateOfBirth(student.getDateOfBirth())
                    .studentEmailId(student.getStudentEmailId())
                    .fatherName(student.getParent().getFatherName())
                    .motherName(student.getParent().getMotherName())
                    .className(student.getStudentClass().getClassName())
                    .build();
            studentWithParentList.add(studentWithParents);
        });

        return ResponseEntity.ok().body(studentWithParentList);
    }
}
