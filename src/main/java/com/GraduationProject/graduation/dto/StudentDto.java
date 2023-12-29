package com.GraduationProject.graduation.dto;


import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private long id;
    private String firstName;
    private String lastName;
    private String facultyNumber;
    private Integer graduationClass;

}
