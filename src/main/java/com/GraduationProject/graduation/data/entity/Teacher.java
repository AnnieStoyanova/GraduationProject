package com.GraduationProject.graduation.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "teacher")
public class Teacher extends BaseEntity {

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Position position;

    private Double salary;

}
