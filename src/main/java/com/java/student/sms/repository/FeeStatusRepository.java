package com.java.student.sms.repository;

import com.java.student.sms.model.entity.FeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeStatusRepository extends JpaRepository<FeeStatus, Long> {
}
