package com.GraduationProject.graduation.web.view.model;

import com.GraduationProject.graduation.data.entity.ApplicationDocument;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateThesisViewModel {

    private String title;
    private String text;
    private Date uploadDate;
    private ApplicationDocument applicationDocument;
}
