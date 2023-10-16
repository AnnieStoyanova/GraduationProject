package com.GraduationProject.graduation.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "applicationDocument")
public class ApplicationDocument extends BaseEntity {

    private String theme;
    private String purpose;
    private List<String> tasks;  // TODO: ask if Task object is better?
    private List<String> technologies; // TODO: same as above
    private Student student;
    private Teacher teacherLeader;



}
