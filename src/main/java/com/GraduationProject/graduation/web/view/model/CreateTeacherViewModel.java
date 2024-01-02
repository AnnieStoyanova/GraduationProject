package com.GraduationProject.graduation.web.view.model;

import com.GraduationProject.graduation.data.entity.Position;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTeacherViewModel {

    private String firstName;

    private String lastName;

    private Position position;
}
