package com.GraduationProject.graduation.web.view.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateStudentViewModel {


    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String firstName;

    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String lastName;

    private Integer creditsToTake;
    private Integer graduationClass;


}
