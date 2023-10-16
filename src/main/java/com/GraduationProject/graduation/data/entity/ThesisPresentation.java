package com.GraduationProject.graduation.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "thesisPresentation")
public class ThesisPresentation extends BaseEntity {

    private Student student;
    private Teacher teacher;
    private Long thesisId; // not sure???
    private Long applicationId;
    private Teacher evaluatingTeacher;
    private Double grade;
    private Date presentationDate;
}

