package com.GraduationProject.graduation.dto;


import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private String firstName;
    private String lastName;
    private Integer creditsToTake;
    private Integer graduationClass;

}
