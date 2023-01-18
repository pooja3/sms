package com.java.student.sms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "students")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "studentId")
    Long studentId;

    Long rollNumber;

    String firstName;

    String lastName;

    Date dateOfBirth;

    String studentEmailId;

    @JsonIgnore()
    @OneToOne
    @JoinColumn(name = "parentId")
    Parent parent;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "classId")
    Class studentClass;

    @JsonIgnore
    @OneToOne(mappedBy = "student")
    Progress progress;

    @JsonIgnore
    @OneToOne(mappedBy = "student")
    FeeStatus feeStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return studentId != null && Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

