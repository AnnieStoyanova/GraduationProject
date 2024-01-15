package com.GraduationProject.graduation.web.api;

import com.GraduationProject.graduation.dto.PresentationInfoDto;
import com.GraduationProject.graduation.services.PresentationInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/presentationInfos")
public class PresentationInfoApiController {

    private final PresentationInfoService presentationInfoService;

    public PresentationInfoApiController(PresentationInfoService presentationInfoService) {
        this.presentationInfoService = presentationInfoService;
    }

    @GetMapping("/grade-between/{startGrade}/and/{endGrade}")
    public List<PresentationInfoDto> getAllPresentationInfosWithGradeBetween(
            @PathVariable Double startGrade, @PathVariable Double endGrade) {
        return presentationInfoService.getThesesByGradeRange(startGrade, endGrade);
    }

    @GetMapping("/count-graduated-with-teacherLeade/{id}")
    public long getCountOfAllGraduatedStudentsWithLeadingTeacher(@PathVariable long id) {
        return presentationInfoService.countByGradeNotAndThesis_ApplicationDocument_TeacherLeader_Id(2.0,id);
    }
}
