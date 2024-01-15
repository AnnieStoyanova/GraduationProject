package com.GraduationProject.graduation.dto;

import com.GraduationProject.graduation.data.entity.Teacher;
import com.GraduationProject.graduation.data.entity.Thesis;
import lombok.*;


import java.time.LocalDate;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecensionDto {

    private long id;
    private Thesis thesis;
    private LocalDate uploadDate;
    private String text;
    private Boolean decision;
    private Teacher evaluatingTeacher;
}
