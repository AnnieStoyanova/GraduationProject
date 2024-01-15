package com.GraduationProject.graduation.dto;


import com.GraduationProject.graduation.data.entity.PresentationInfo;
import com.GraduationProject.graduation.data.entity.Teacher;
import lombok.*;


import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThesisPresentationDto {

    private List<PresentationInfo> presentationInfos;
    private List<Teacher> commission;
    private LocalDate presentationDate;
}
