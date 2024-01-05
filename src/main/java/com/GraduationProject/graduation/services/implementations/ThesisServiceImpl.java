package com.GraduationProject.graduation.services.implementations;

import com.GraduationProject.graduation.data.entity.Student;
import com.GraduationProject.graduation.data.entity.Thesis;
import com.GraduationProject.graduation.data.repository.ThesisRepository;
import com.GraduationProject.graduation.dto.*;
import com.GraduationProject.graduation.services.ApplicationDocumentService;
import com.GraduationProject.graduation.services.ThesisService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ThesisServiceImpl implements ThesisService {

    private final ThesisRepository thesisRepository;

    private ApplicationDocumentService applicationDocumentService;

    private final ModelMapper modelMapper;
    @Override
    public List<ThesisDto> getTheses() {
        return thesisRepository.findAll().stream()
                .map(this::convertToThesisDto)
                .collect(Collectors.toList());
    }

    @Override
    public ThesisDto getThesisById(long id) {
        return modelMapper.map(thesisRepository.findById(id), ThesisDto.class);
    }

    @Override
    public CreateThesisDto createThesis(CreateThesisDto createThesisDto) {
        return modelMapper.map(
                thesisRepository.save(
                        modelMapper.map(createThesisDto, Thesis.class)), CreateThesisDto.class);
    }

    @Override
    public UpdateThesisDto updateThesis(long id, UpdateThesisDto updateThesisDto) {
        Thesis thesis = modelMapper.map(getThesisById(id), Thesis.class);
        thesis.setText(updateThesisDto.getText());
        thesis.setTitle(updateThesisDto.getTitle());
        thesis.setApplicationDocument(updateThesisDto.getApplicationDocument());
        thesis.setUploadDate(updateThesisDto.getUploadDate());
        return modelMapper.map(thesisRepository.save(thesis), UpdateThesisDto.class);
    }

    @Override
    public void deleteThesis(long id) {
        thesisRepository.deleteById(id);
    }

    @Override
    public List<ApplicationDocumentDto> getThesisApplications() {
        return applicationDocumentService.getApplications();
    }

    private ThesisDto convertToThesisDto(Thesis thesis) {
        return modelMapper.map(thesis, ThesisDto.class);
    }

}
