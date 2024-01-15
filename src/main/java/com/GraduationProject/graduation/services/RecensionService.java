package com.GraduationProject.graduation.services;

import com.GraduationProject.graduation.dto.CreateRecensionDto;

public interface RecensionService {

    CreateRecensionDto createRecension(CreateRecensionDto createRecensionDto);

    public long getCountOfFalseDecisions();
}
