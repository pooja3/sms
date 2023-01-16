package com.java.student.sms.repository;

import com.java.student.sms.model.entity.FeeStructure;
import com.java.student.sms.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeeStructureRepository extends JpaRepository<FeeStructure, Long> {
}
