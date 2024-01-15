package com.GraduationProject.graduation.services.implementations;

import com.GraduationProject.graduation.data.entity.Recension;
import com.GraduationProject.graduation.data.repository.RecensionRepository;
import com.GraduationProject.graduation.dto.CreateRecensionDto;
import com.GraduationProject.graduation.services.RecensionService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecensionServiceImpl implements RecensionService {

    private final RecensionRepository recensionRepository;

    private final ModelMapper modelMapper;
    @Override
    public CreateRecensionDto createRecension(CreateRecensionDto createRecensionDto) {
        return modelMapper.map(
                recensionRepository.save(
                        modelMapper.map(createRecensionDto, Recension.class)), CreateRecensionDto.class);
    }

    @Override
    public long getCountOfFalseDecisions() {
        return recensionRepository.countByDecisionIsFalse();
    }
}
