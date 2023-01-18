package com.java.student.sms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java.student.sms.model.entity.enums.FeeStatusType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "fee_status")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class FeeStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long feeStatusId;

    Float amountPaid;

    Float amountPending;

    FeeStatusType feeStatusType;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "studentId")
    Student student;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FeeStatus feeStatus = (FeeStatus) o;
        return feeStatusId != null && Objects.equals(feeStatusId, feeStatus.feeStatusId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
