package com.java.student.sms.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "classes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long classId;

    String className;

    Integer studentsMax;

    Integer studentsMin;

    Integer strength;

    Long courseId;
}
