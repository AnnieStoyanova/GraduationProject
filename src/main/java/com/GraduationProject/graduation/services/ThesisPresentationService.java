package com.GraduationProject.graduation.services;

import com.GraduationProject.graduation.dto.ThesisPresentationDto;

import java.time.LocalDate;
import java.util.List;

public interface ThesisPresentationService {

    List<ThesisPresentationDto> getThesisPresentations();

    ThesisPresentationDto getThesisPresentationById(long id);
    List<ThesisPresentationDto> getPresentationsInPeriodWithGradeNot2(LocalDate startDate, LocalDate endDate);
//    long countPresentationInfosByPresentationDateBetween(LocalDate startDate, LocalDate endDate);

}
