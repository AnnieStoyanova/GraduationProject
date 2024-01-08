package com.GraduationProject.graduation.web.view.model;

import com.GraduationProject.graduation.data.entity.ApplicationDocument;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateThesisViewModel {

    private String title;
    private String text;
    private LocalDate uploadDate;
    private ApplicationDocument applicationDocument;
}
