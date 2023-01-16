package com.java.student.sms.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "progress")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long progressId;

    Float overallPercentage;
    Long studentInd;
    @Column
    @ElementCollection(targetClass = Integer.class)
    private List<Integer> marks;
}
