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
public class StudentWithClass {

    Long rollNumber;

    String firstName;

    String lastName;

    Date dateOfBirth;

    String emailId;

    String className;
}
