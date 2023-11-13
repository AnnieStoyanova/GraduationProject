package com.GraduationProject.graduation.dto;

import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateStudentDTO {
    private String firstName;
    private String lastName;
    private Integer creditsToTake;
    private Boolean isTaxPaid;

}
