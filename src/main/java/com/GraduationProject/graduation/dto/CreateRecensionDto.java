package com.GraduationProject.graduation.dto;

import com.GraduationProject.graduation.data.entity.Teacher;
import com.GraduationProject.graduation.data.entity.Thesis;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateRecensionDto {

    private Thesis thesis;
    private LocalDate uploadDate;
    private String text;
    private Boolean decision;
    private Teacher evaluatingTeacher;

}
