package com.GraduationProject.graduation.dto;

import com.GraduationProject.graduation.data.entity.Thesis;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PresentationInfoDto {

    private long id;
    private Thesis thesis;
    private Double grade;
}
