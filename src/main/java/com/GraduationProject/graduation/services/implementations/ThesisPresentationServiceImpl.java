package com.GraduationProject.graduation.services.implementations;


import com.GraduationProject.graduation.data.entity.ThesisPresentation;
import com.GraduationProject.graduation.data.repository.ThesisPresentationRepository;
import com.GraduationProject.graduation.exceptions.ThesisPresentationNotFoundException;
import org.modelmapper.ModelMapper;
import com.GraduationProject.graduation.dto.ThesisPresentationDto;
import com.GraduationProject.graduation.services.ThesisPresentationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ThesisPresentationServiceImpl implements ThesisPresentationService {

    private final ThesisPresentationRepository thesisPresentationRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<ThesisPresentationDto> getThesisPresentations() {
        return thesisPresentationRepository.findAll().stream()
                .map(this::convertToThesisPresentationDto)
                .collect(Collectors.toList());
    }

    @Override
    public ThesisPresentationDto getThesisPresentationById(long id) {
        return modelMapper.map(thesisPresentationRepository.findById(id)
                .orElseThrow(() -> new ThesisPresentationNotFoundException("Invalid thesis presentation Id:" + id)), ThesisPresentationDto.class);

    }

    @Override
    public List<ThesisPresentationDto> getPresentationsInPeriodWithGradeNot2(LocalDate startDate, LocalDate endDate) {
        Double gradeToExclude = 2.0;
        return thesisPresentationRepository.findByPresentationDateBetweenAndPresentationInfos_GradeNot(startDate, endDate, gradeToExclude)
                .stream()
                .map(this::convertToThesisPresentationDto)
                .collect(Collectors.toList());
    }

//    @Override
//    public long countPresentationInfosByPresentationDateBetween(LocalDate startDate, LocalDate endDate) {
//        return thesisPresentationRepository.countPresentationInfosByPresentationDateBetween(startDate, endDate);
//    }


    private ThesisPresentationDto convertToThesisPresentationDto(ThesisPresentation thesisPresentation) {
        return modelMapper.map(thesisPresentation, ThesisPresentationDto.class);
    }
}
