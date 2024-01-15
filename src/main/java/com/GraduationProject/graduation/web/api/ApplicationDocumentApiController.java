package com.GraduationProject.graduation.web.api;


import com.GraduationProject.graduation.dto.CreateApplicationDocumentDto;
import com.GraduationProject.graduation.dto.ApplicationDocumentDto;
import com.GraduationProject.graduation.services.ApplicationDocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/applicationDocuments")
public class ApplicationDocumentApiController {
    
    private final ApplicationDocumentService applicationDocumentService;

    public ApplicationDocumentApiController(ApplicationDocumentService documentService) {
        this.applicationDocumentService = documentService;
    }

    @GetMapping
    List<ApplicationDocumentDto> getApplicationDocuments() {
        return applicationDocumentService.getApplications();
    }

    @PostMapping("/create-applicationDocument")
    public CreateApplicationDocumentDto createApplicationDocument(@RequestBody CreateApplicationDocumentDto createApplicationDocumentDto) {
        return this.applicationDocumentService.createApplication(createApplicationDocumentDto);
    }

    @GetMapping("/{id}")
    public ApplicationDocumentDto getApplicationDocumentById(@PathVariable long id) {
        return this.applicationDocumentService.getApplicationById(id);
    }

    @GetMapping("/only-approved")
    public List<ApplicationDocumentDto> getAllApprovedApplications() {
        return this.applicationDocumentService.findAllByIsApprovedIsTrue();
    }

    @GetMapping("/contain/{substringTheme}")
    public List<ApplicationDocumentDto> getAllContainingSubstringInTheme(@PathVariable String substringTheme) {
        return this.applicationDocumentService.findAllByThemeContainingOrderByTheme(substringTheme);
    }

    @GetMapping("/byTeacher/{id}/only-approved")
    public List<ApplicationDocumentDto> getAllApprovedApplicationsLeadingTeacherIs(
            @PathVariable long id) {
        return this.applicationDocumentService.findByTeacherLeaderIdAndIsApprovedTrue(id);
    }


}
