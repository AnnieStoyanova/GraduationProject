package com.GraduationProject.graduation.web.view.model;

import com.GraduationProject.graduation.data.entity.ApplicationDocument;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateThesisViewModel {

    private String title;
    private String text;
    private Date uploadDate;
    private ApplicationDocument applicationDocument;
}
