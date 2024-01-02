package com.GraduationProject.graduation.web.view.model;

import com.GraduationProject.graduation.data.entity.Student;
import com.GraduationProject.graduation.data.entity.Teacher;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;


@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationViewModel {

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
