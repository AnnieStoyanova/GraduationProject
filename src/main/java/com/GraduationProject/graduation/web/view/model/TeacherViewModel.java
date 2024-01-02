package com.GraduationProject.graduation.web.view.model;


import com.GraduationProject.graduation.data.entity.Position;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherViewModel {

    private long id;
    private String firstName;

    private String lastName;

    private Position position;
}
