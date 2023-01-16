package com.java.student.sms.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long studentId;

    Long rollNumber;

    String firstName;

    String lastName;

    Date dateOfBirth;

    String emailId;

    Long parentId;

    Long classId;
}

