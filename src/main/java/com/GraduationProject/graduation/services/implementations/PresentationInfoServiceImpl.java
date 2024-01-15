package com.GraduationProject.graduation.services.implementations;

import com.GraduationProject.graduation.data.entity.PresentationInfo;
import com.GraduationProject.graduation.data.repository.PresentationInfoRepository;
import com.GraduationProject.graduation.dto.PresentationInfoDto;
import com.GraduationProject.graduation.services.PresentationInfoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PresentationInfoServiceImpl implements PresentationInfoService {
    
    private final PresentationInfoRepository presentationInfoRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<PresentationInfoDto> getThesesByGradeRange(Double startGrade, Double endGrade) {
        return presentationInfoRepository.findByGradeBetween(startGrade, endGrade)
                .stream()
                .map(this::convertToPresentationInfoDto)
                .collect(Collectors.toList());
    }

    @Override
    public long countByGradeNotAndThesis_ApplicationDocument_TeacherLeader_Id(Double grade, long id) {
        return presentationInfoRepository.countByGradeNotAndThesis_ApplicationDocument_TeacherLeader_Id(2.0,id);
    }

    private PresentationInfoDto convertToPresentationInfoDto(PresentationInfo presentationInfo) {
        return modelMapper.map(presentationInfo, PresentationInfoDto.class);
    }
}
