package com.java.student.sms.repository;

import com.java.student.sms.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstNameContaining(String firstName);

    @Query(value = "SELECT * FROM students INNER JOIN classes on students.classId = classes.classId INNER JOIN progress on students.studentId = progress.studentId WHERE classes.className = :className ORDER BY progress.overallPercentage DESC", nativeQuery = true)
    List<Student> findTopperByClassName(@Param("className") String className);

    @Query(value = "SELECT * FROM students INNER JOIN classes on students.classId = classes.classId INNER JOIN progress on students.studentId = progress.studentId WHERE students.studentId = :studentId", nativeQuery = true)
    List<Student> findProgressOfStudent(@Param("studentId") Long studentId);

    // List<Student> findByProgress_OverallPercentageGreaterThan(@NonNull Float overallPercentage);
    // Alternate working way to fetch above query. This is JPA way of fetching query.
}
