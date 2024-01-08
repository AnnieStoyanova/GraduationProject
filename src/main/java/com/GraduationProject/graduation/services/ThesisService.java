package com.GraduationProject.graduation.services;

import com.GraduationProject.graduation.dto.ApplicationDocumentDto;
import com.GraduationProject.graduation.dto.CreateThesisDto;
import com.GraduationProject.graduation.dto.ThesisDto;
import com.GraduationProject.graduation.dto.UpdateThesisDto;

import java.util.List;

public interface ThesisService {

    List<ThesisDto> getTheses();

    ThesisDto getThesisById(long id);

    CreateThesisDto createThesis(CreateThesisDto createThesisDto);

    UpdateThesisDto updateThesis(long id, UpdateThesisDto updateThesisDto);

    void deleteThesis(long id);

    List<ApplicationDocumentDto> getThesisApplications();
}
