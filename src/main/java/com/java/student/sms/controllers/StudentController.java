package com.java.student.sms.controllers;

import com.java.student.sms.model.entity.Student;
import com.java.student.sms.model.response.StudentProgress;
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

    /**
     * @param className: This should basically range from 1st - 12th
     * @return Topper of the class.
     */
    @GetMapping("/api/students/topper/{className}")
    public ResponseEntity<?> findTopperOfClass(@PathVariable("className") String className) {
        List<Student> students = studentRepository.findTopperByClassName(className);
        if(!students.isEmpty()) {
            Student topperStudent = students.get(0);
            StudentProgress studentProgress = StudentProgress.builder()
                    .rollNumber(topperStudent.getRollNumber())
                    .firstName(topperStudent.getFirstName())
                    .lastName(topperStudent.getLastName())
                    .emailId(topperStudent.getStudentEmailId())
                    .overallPercentage(topperStudent.getProgress().getOverallPercentage().toString()+"%")
                    .className(topperStudent.getStudentClass().getClassName())
                    .build();
            return ResponseEntity.ok().body(studentProgress);
        }
        return ResponseEntity.badRequest().build();
    }

    /**
     * @param studentId
     * @return Topper of the class.
     */
    @GetMapping("/api/students/progress/{studentId}")
    public ResponseEntity<?> findOverallPercentageOfStudent(@PathVariable("studentId") Long studentId) {
        List<Student> students = studentRepository.findProgressOfStudent(studentId);
        if(!students.isEmpty()) {
            Student student = students.get(0);
            StudentProgress studentProgress = StudentProgress.builder()
                    .rollNumber(student.getRollNumber())
                    .firstName(student.getFirstName())
                    .lastName(student.getLastName())
                    .emailId(student.getStudentEmailId())
                    .overallPercentage(student.getProgress().getOverallPercentage().toString()+"%")
                    .className(student.getStudentClass().getClassName())
                    .build();
            return ResponseEntity.ok().body(studentProgress);
        }
        return ResponseEntity.badRequest().build();
    }
}
