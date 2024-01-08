package com.GraduationProject.graduation.dto;

import com.GraduationProject.graduation.data.entity.ApplicationDocument;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateThesisDto {

    private String title;
    private String text;
    private LocalDate uploadDate;
    private ApplicationDocument applicationDocument;
}
