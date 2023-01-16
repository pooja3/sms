package com.java.student.sms.repository;

import com.java.student.sms.model.entity.Parent;
import com.java.student.sms.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Long> {
}
