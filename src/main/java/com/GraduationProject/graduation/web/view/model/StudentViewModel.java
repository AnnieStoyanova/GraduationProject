package com.GraduationProject.graduation.web.view.model;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentViewModel {
    private long id;
    private String firstName;
    private String lastName;
    private String facultyNumber;
    private Integer graduationClass;

}