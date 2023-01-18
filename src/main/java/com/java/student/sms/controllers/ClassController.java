package com.java.student.sms.controllers;

import com.java.student.sms.model.entity.Class;
import com.java.student.sms.model.response.ClassWithFees;
import com.java.student.sms.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/api/class")
public class ClassController {

    @Autowired
    ClassRepository classRepository;

    @GetMapping("/fees/{classInput}")
    public ResponseEntity<?> getClassWithFees(@PathVariable("classInput") String classInput) {
        Optional<Class> optionalClassWithFees = classRepository.findByClassName(classInput);

        if (optionalClassWithFees.isPresent()) {
            Class classWithFees = optionalClassWithFees.get();
            Float tuitionFees = classWithFees.getFeeStructure().getBaseAmount() * classWithFees.getFeeStructure().getFeeType().getValue();
            Float additionalCharges = (classWithFees.getFeeStructure().getBaseAmount() * classWithFees.getFeeStructure().getFeeType().getValue()) / 2;
            float overallFees = tuitionFees + additionalCharges;
            ClassWithFees responseClassWithFees = ClassWithFees.builder()
                    .className(classWithFees.getClassName())
                    .tuitionFees(tuitionFees)
                    .additionalCharges(additionalCharges)
                    .overallFees(Float.toString(overallFees))
                    .build();

            return ResponseEntity.ok().body(responseClassWithFees);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Class name not found");
        }
    }
}
