package com.java.student.sms.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassWithFees {

    String className;

    Float tuitionFees;

    Float additionalCharges;

    String overallFees;
}
