package com.java.student.sms.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentProgress {

    Long rollNumber;

    String firstName;

    String lastName;

    String overallPercentage;

    String emailId;

    String className;
}
