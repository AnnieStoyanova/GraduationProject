package com.GraduationProject.graduation.dto;

import com.GraduationProject.graduation.data.entity.Position;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateTeacherDto {

    private String firstName;

    private String lastName;

    private Position position;
}
