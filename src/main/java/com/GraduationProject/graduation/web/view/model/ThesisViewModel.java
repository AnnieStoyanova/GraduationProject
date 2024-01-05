package com.GraduationProject.graduation.web.view.model;

import com.GraduationProject.graduation.data.entity.ApplicationDocument;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThesisViewModel {

    private long id;
    private String title;
    private String text;
    private Date uploadDate;
    private ApplicationDocument applicationDocument;
}
