package com.GraduationProject.graduation.web.api;

import com.GraduationProject.graduation.dto.ThesisPresentationDto;
import com.GraduationProject.graduation.services.ThesisPresentationService;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/thesis-presentations")
public class ThesisPresentationApiController {

    private final ThesisPresentationService thesisPresentationService;


    public ThesisPresentationApiController(ThesisPresentationService thesisPresentationService) {
        this.thesisPresentationService = thesisPresentationService;
    }

    @GetMapping("/only-graduated-between/{startDate}/and/{endDate}")
    public List<ThesisPresentationDto> getAllGradutedStudentsBetween(
            @PathVariable LocalDate startDate, @PathVariable LocalDate endDate) {
        return this.thesisPresentationService.getPresentationsInPeriodWithGradeNot2(startDate,endDate);

    }


}
