package com.GraduationProject.graduation.web.view.model;

import com.GraduationProject.graduation.data.entity.Student;
import com.GraduationProject.graduation.data.entity.Teacher;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateApplicationViewModel {

    @NotBlank
    private String theme;
    @NotBlank
    private String purpose;
    private String tasks;
    private String technologies;
    private Student student;
    private Teacher teacherLeader;
    private Boolean isApproved;
}
