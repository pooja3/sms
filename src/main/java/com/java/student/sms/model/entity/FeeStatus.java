package com.java.student.sms.model.entity;

import com.java.student.sms.model.entity.enums.FeeStatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "fee_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeeStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long feeStatusId;

    Long studentId;

    Float amountPaid;

    Float amountPending;

    FeeStatusType feeStatusType;
}
