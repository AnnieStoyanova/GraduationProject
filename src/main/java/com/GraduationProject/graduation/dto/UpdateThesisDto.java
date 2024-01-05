package com.GraduationProject.graduation.dto;

import com.GraduationProject.graduation.data.entity.ApplicationDocument;
import lombok.*;


@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateThesisDto {

    private String title;
    private String text;
    private ApplicationDocument applicationDocument;
}
