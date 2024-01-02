package com.GraduationProject.graduation.dto;

import com.GraduationProject.graduation.data.entity.Student;
import com.GraduationProject.graduation.data.entity.Teacher;
import lombok.*;

import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateApplicationDocumentDto {
    private String theme;
    private String purpose;
    private String tasks;
    private String technologies;
    private Student student;
    private Teacher teacherLeader;
    private Boolean isApproved;
}
