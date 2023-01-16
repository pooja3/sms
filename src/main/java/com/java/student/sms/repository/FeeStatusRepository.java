package com.java.student.sms.repository;

import com.java.student.sms.model.entity.FeeStatus;
import com.java.student.sms.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeeStatusRepository extends JpaRepository<FeeStatus, Long> {
}
