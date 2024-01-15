package com.GraduationProject.graduation.services;

import com.GraduationProject.graduation.data.entity.ApplicationDocument;
import com.GraduationProject.graduation.dto.*;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ApplicationDocumentService {

    List<ApplicationDocumentDto> getApplications();

    ApplicationDocumentDto getApplicationById(long id);

    CreateApplicationDocumentDto createApplication(CreateApplicationDocumentDto createApplicationDocumentDto);

    UpdateApplicationDocumentDto updateApplication(long id, UpdateApplicationDocumentDto updateApplicationDocumentDto);

    void deleteApplication(long id);

    List<StudentDto> getApplicationStudents();

    List<TeacherDto> getApplicationTeachers();

    List<ApplicationDocumentDto> findAllByIsApprovedIsTrue();

    List<ApplicationDocumentDto> findAllByThemeContainingOrderByTheme(String substringTheme);

    List<ApplicationDocumentDto> findByTeacherLeaderIdAndIsApprovedTrue(Long teacherId);

}
