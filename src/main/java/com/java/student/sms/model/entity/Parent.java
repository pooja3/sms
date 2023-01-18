package com.java.student.sms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "parents")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "parentId")
    Long parentId;

    String fatherName;

    String motherName;

    String contactInfo;

    String address;

    String parentEmailId;

    @JsonIgnore
    @OneToOne(mappedBy = "parent")
    Student student;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Parent parent = (Parent) o;
        return parentId != null && Objects.equals(parentId, parent.parentId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
