package com.GraduationProject.graduation.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "presentationInfo")
public class PresentationInfo extends BaseEntity {
    @OneToOne
    private Thesis thesis;
    private Double grade;
}
