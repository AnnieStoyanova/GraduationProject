package com.GraduationProject.graduation.services.implementations;

import com.GraduationProject.graduation.data.entity.ApplicationDocument;
import com.GraduationProject.graduation.data.repository.ApplicationDocumentRepository;
import com.GraduationProject.graduation.dto.*;
import com.GraduationProject.graduation.exceptions.ApplicationDocumentNotFoundException;
import com.GraduationProject.graduation.services.ApplicationDocumentService;
import com.GraduationProject.graduation.services.StudentService;
import com.GraduationProject.graduation.services.TeacherService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationDocumentServiceImpl implements ApplicationDocumentService {

    private final ApplicationDocumentRepository applicationDocumentRepository;

    private final StudentService studentService;

    private final TeacherService teacherService;

    private final ModelMapper modelMapper;

    @Override
    public List<ApplicationDocumentDto> getApplications() {
        return applicationDocumentRepository.findAll().stream()
                .map(this::convertToApplicationDto)
                .collect(Collectors.toList());
    }

    @Override
    public ApplicationDocumentDto getApplicationById(long id) {
        return modelMapper.map(applicationDocumentRepository.findById(id)
                .orElseThrow(() -> new ApplicationDocumentNotFoundException("Invalid application document Id:" + id)), ApplicationDocumentDto.class);
    }

    @Override
    public CreateApplicationDocumentDto createApplication(CreateApplicationDocumentDto createApplicationDocumentDto) {
        return modelMapper.map(
                applicationDocumentRepository.save(
                        modelMapper.map(createApplicationDocumentDto, ApplicationDocument.class)), CreateApplicationDocumentDto.class);
    }

    @Override
    public UpdateApplicationDocumentDto updateApplication(long id, UpdateApplicationDocumentDto updateApplicationDocumentDto) {
        ApplicationDocument document = modelMapper.map(getApplicationById(id), ApplicationDocument.class);
        document.setTheme(updateApplicationDocumentDto.getTheme());
        document.setPurpose(updateApplicationDocumentDto.getPurpose());
        document.setTasks(updateApplicationDocumentDto.getTasks());
        document.setTechnologies(updateApplicationDocumentDto.getTechnologies());
        document.setStudent(updateApplicationDocumentDto.getStudent());
        document.setTeacherLeader(updateApplicationDocumentDto.getTeacherLeader());
        document.setIsApproved(updateApplicationDocumentDto.getIsApproved());
        return modelMapper.map(applicationDocumentRepository.save(document), UpdateApplicationDocumentDto.class);
    }

    @Override
    public void deleteApplication(long id) {
        applicationDocumentRepository.deleteById(id);
    }

    @Override
    public List<StudentDto> getApplicationStudents() {
        return studentService.getStudents();
    }

    @Override
    public List<TeacherDto> getApplicationTeachers() { return teacherService.getTeachers();}


    @Override
    public List<ApplicationDocumentDto> findAllByIsApprovedIsTrue() {
        return applicationDocumentRepository.findAllByIsApprovedIsTrue().stream()
                .map(this::convertToApplicationDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplicationDocumentDto> findAllByThemeContainingOrderByTheme(String substringTheme) {
        return applicationDocumentRepository.findAllByThemeContainingOrderByTheme(substringTheme).stream()
                .map(this::convertToApplicationDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplicationDocumentDto> findByTeacherLeaderIdAndIsApprovedTrue(Long teacherId) {
        return applicationDocumentRepository.findByTeacherLeaderIdAndIsApprovedTrue(teacherId)
                .stream()
                .map(this::convertToApplicationDto)
                .collect(Collectors.toList());
    }


    private ApplicationDocumentDto convertToApplicationDto(ApplicationDocument applicationDocument) {
        return modelMapper.map(applicationDocument, ApplicationDocumentDto.class);
    }
}
