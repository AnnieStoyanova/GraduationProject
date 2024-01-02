package com.GraduationProject.graduation.web.view.model;

import com.GraduationProject.graduation.data.entity.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateTeacherViewModel {

    private String firstName;

    private String lastName;

    private Position position;
}
