package com.java.student.sms.repository;

import com.java.student.sms.model.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {

    Optional<Class> findByClassName(String classInput);
}
