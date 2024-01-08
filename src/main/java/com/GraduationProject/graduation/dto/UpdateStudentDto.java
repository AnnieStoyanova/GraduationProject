package com.GraduationProject.graduation.dto;

import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateStudentDto {
    private String firstName;
    private String lastName;
    private String facultyNumber;
    private Integer graduationClass;

}
