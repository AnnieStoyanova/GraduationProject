package com.GraduationProject.graduation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateStudentDto {
    private String firstName;
    private String lastName;
}
