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
@Table(name = "thesis")
public class Thesis extends BaseEntity {

    private String title;
    private String text;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate uploadDate;
    @OneToOne
    private ApplicationDocument applicationDocument;
}
