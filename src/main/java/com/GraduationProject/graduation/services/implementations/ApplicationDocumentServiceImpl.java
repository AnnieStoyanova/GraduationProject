package com.GraduationProject.graduation.services.implementations;

import com.GraduationProject.graduation.data.entity.ApplicationDocument;
import com.GraduationProject.graduation.data.entity.Student;
import com.GraduationProject.graduation.data.repository.ApplicationDocumentRepository;
import com.GraduationProject.graduation.dto.*;
import com.GraduationProject.graduation.services.ApplicationDocumentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationDocumentServiceImpl implements ApplicationDocumentService {

    private final ApplicationDocumentRepository applicationDocumentRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<ApplicationDocumentDto> getApplications() {
        return applicationDocumentRepository.findAll().stream()
                .map(this::convertToApplicationDto)
                .collect(Collectors.toList());
    }

    @Override
    public ApplicationDocumentDto getApplicationById(long id) {
        return modelMapper.map(applicationDocumentRepository.findById(id), ApplicationDocumentDto.class);
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

    private ApplicationDocumentDto convertToApplicationDto(ApplicationDocument applicationDocument) {
        return modelMapper.map(applicationDocument, ApplicationDocumentDto.class);
    }
}
