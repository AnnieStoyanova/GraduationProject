package com.GraduationProject.graduation.dto;

import com.GraduationProject.graduation.data.entity.Position;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {

    private long id;

    private String firstName;

    private String lastName;

    private Position position;
}
