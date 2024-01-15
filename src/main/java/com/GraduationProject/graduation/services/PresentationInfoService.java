package com.GraduationProject.graduation.services;

import com.GraduationProject.graduation.dto.PresentationInfoDto;

import java.util.List;

public interface PresentationInfoService {
    List<PresentationInfoDto> getThesesByGradeRange(Double startGrade, Double endGrade);

    long countByGradeNotAndThesis_ApplicationDocument_TeacherLeader_Id(Double grade, long id);
}
