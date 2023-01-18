package com.java.student.sms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "classes")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "classId")
    Long classId;

    String className;

    Integer studentsMax;

    Integer studentsMin;

    Integer strength;

    @JsonIgnore
    @OneToOne(mappedBy = "studentClass")
    Student student;

    @JsonIgnore
    @OneToOne(mappedBy = "classWithFees")
    FeeStructure feeStructure;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Class aClass = (Class) o;
        return classId != null && Objects.equals(classId, aClass.classId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
