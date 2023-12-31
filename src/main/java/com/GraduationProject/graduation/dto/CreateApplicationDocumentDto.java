package com.GraduationProject.graduation.dto;

import com.GraduationProject.graduation.data.entity.Student;
import com.GraduationProject.graduation.data.entity.Teacher;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateApplicationDocumentDto {

    private String theme;
    private String purpose;
    private String tasks;
    private String technologies;
    private Student student;
    private Teacher teacherLeader;
    private Boolean isApproved;
}
