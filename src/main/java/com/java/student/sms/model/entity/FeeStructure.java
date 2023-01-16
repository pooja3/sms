package com.java.student.sms.model.entity;

import com.java.student.sms.model.entity.enums.FeeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "fee_structure")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeeStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long feesId;

    Float baseAmount;

    @Enumerated(EnumType.ORDINAL)
    FeeType feeType;

    Long classId;
}
