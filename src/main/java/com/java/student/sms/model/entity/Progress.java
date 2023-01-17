package com.java.student.sms.model.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "progress")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "progressId")
    Long progressId;

    Float overallPercentage;

    Long studentId;

    @Column
    @ElementCollection(targetClass = Integer.class)
    private List<Integer> marks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Progress progress = (Progress) o;
        return progressId != null && Objects.equals(progressId, progress.progressId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
