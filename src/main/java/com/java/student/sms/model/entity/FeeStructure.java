package com.java.student.sms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java.student.sms.model.entity.enums.FeeType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "fee_structure")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class FeeStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long feesId;

    Float baseAmount;

    @Enumerated(EnumType.ORDINAL)
    FeeType feeType;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "classId")
    Class classWithFees;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FeeStructure that = (FeeStructure) o;
        return feesId != null && Objects.equals(feesId, that.feesId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
