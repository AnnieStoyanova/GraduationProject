package com.GraduationProject.graduation.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "recension")
public class Recension extends BaseEntity {

    @OneToOne
    private Thesis thesis;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate uploadDate;
    private String text;
    private Boolean decision;
    @OneToOne
    private Teacher evaluatingTeacher;
}
