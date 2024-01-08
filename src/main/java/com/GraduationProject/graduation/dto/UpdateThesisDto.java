package com.GraduationProject.graduation.dto;

import com.GraduationProject.graduation.data.entity.ApplicationDocument;
import lombok.*;

import java.time.LocalDate;


@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateThesisDto {

    private String title;
    private String text;
    private LocalDate uploadDate;
    private ApplicationDocument applicationDocument;
}
