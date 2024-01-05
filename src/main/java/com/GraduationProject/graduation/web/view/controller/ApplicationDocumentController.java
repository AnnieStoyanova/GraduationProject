package com.GraduationProject.graduation.web.view.controller;

import com.GraduationProject.graduation.dto.*;
import com.GraduationProject.graduation.services.ApplicationDocumentService;
import com.GraduationProject.graduation.web.view.model.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/applications")
public class ApplicationDocumentController {

    private final ApplicationDocumentService applicationDocumentService;
    private final ModelMapper modelMapper;


    @GetMapping
    private String getApplications(Model model) {
        final List<ApplicationViewModel> applications =
                applicationDocumentService.getApplications().stream()
                        .map(this::convertToApplicationViewModel)
                        .collect(Collectors.toList());
        model.addAttribute("applications", applications);
        return "/applications/applications";
    }

    @GetMapping("/create-application")
    public String showCreateApplicationForm(Model model) {
        model.addAttribute("applicationDocument", new CreateApplicationViewModel());
        model.addAttribute("students", applicationDocumentService.getApplicationStudents());
        model.addAttribute("teachers", applicationDocumentService.getApplicationTeachers());
        return "/applications/create-application";
    }

    @PostMapping("/create")
    public String createApplication(@Valid @ModelAttribute("applicationDocument") CreateApplicationViewModel application,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/applications/create-application";
        }
        applicationDocumentService.createApplication(modelMapper.map(application, CreateApplicationDocumentDto.class));
        return "redirect:/applications";
    }

    @GetMapping("/edit-application/{id}")
    public String showEditApplicationForm(Model model, @PathVariable Long id) {
        model.addAttribute("applicationDocument", modelMapper.map(applicationDocumentService.getApplicationById(id),
                UpdateApplicationViewModel.class));
        model.addAttribute("students", applicationDocumentService.getApplicationStudents());
        model.addAttribute("teachers", applicationDocumentService.getApplicationTeachers());
        return "/applications/edit-application";
    }

    @PostMapping("/update/{id}")
    public String updateApplication(@PathVariable long id, @Valid @ModelAttribute("applicationDocument") UpdateApplicationViewModel application,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/applications/edit-application";
        }
        applicationDocumentService.updateApplication(id, modelMapper.map(application, UpdateApplicationDocumentDto.class));
        return "redirect:/applications";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable long id) {
        applicationDocumentService.deleteApplication(id);
        return "redirect:/applications";
    }

    private ApplicationViewModel convertToApplicationViewModel(ApplicationDocumentDto applicationDocumentDto) {
        return modelMapper.map(applicationDocumentDto, ApplicationViewModel.class);
    }
}
