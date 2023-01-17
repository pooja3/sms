package com.java.student.sms.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentWithParents {

    Long rollNumber;

    String firstName;

    String lastName;

    Date dateOfBirth;

    String studentEmailId;

    String className;

    String fatherName;

    String motherName;
}
