package com.GraduationProject.graduation.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "recension")
public class Recension extends BaseEntity {

    private Thesis thesis;
    private Date uploadDate;
    private String text;
    private Boolean decision;
    private Teacher evaluatingTeacher;
}
