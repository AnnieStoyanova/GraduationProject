package com.GraduationProject.graduation.web.view.model;

import com.GraduationProject.graduation.data.entity.ApplicationDocument;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThesisViewModel {

    private long id;
    private String title;
    private String text;
    private LocalDate uploadDate;
    private ApplicationDocument applicationDocument;
}
