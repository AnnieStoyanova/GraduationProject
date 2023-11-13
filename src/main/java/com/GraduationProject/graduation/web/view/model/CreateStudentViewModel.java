package com.GraduationProject.graduation.web.view.model;

public class CreateStudentViewModel {

    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String firstName;

    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String lastName;

}
