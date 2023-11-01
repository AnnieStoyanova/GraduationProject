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
@Table(name = "thesis")
public class Thesis extends BaseEntity {

    private String title;
    private String text;
    private Date uploadDate;
    private ApplicationDocument applicationDocument;
}
