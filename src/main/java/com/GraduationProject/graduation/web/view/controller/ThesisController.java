package com.GraduationProject.graduation.web.view.controller;


import com.GraduationProject.graduation.dto.CreateThesisDto;
import com.GraduationProject.graduation.dto.ThesisDto;
import com.GraduationProject.graduation.dto.UpdateThesisDto;
import com.GraduationProject.graduation.services.ThesisService;
import com.GraduationProject.graduation.web.view.model.CreateThesisViewModel;
import com.GraduationProject.graduation.web.view.model.ThesisViewModel;
import com.GraduationProject.graduation.web.view.model.UpdateThesisViewModel;
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
@RequestMapping("/theses")
public class ThesisController {
    
    private final ThesisService thesisService;
    private final ModelMapper modelMapper;

    @GetMapping
    private String getTheses(Model model) {
        final List<ThesisViewModel> theses =
                thesisService.getTheses().stream()
                        .map(this::convertToThesisViewModel)
                        .collect(Collectors.toList());
        model.addAttribute("theses", theses);
        return "/theses/theses";
    }

    @GetMapping("/create-thesis")
    public String showCreateThesisForm(Model model) {
        model.addAttribute("thesis", new CreateThesisViewModel());
        model.addAttribute("applicationDocuments",thesisService.getThesisApplications());
        return "/theses/create-thesis";
    }

    @PostMapping("/create")
    public String createThesis(@Valid @ModelAttribute("thesis") CreateThesisViewModel thesis,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/theses/create-thesis";
        }
        thesisService.createThesis(modelMapper.map(thesis, CreateThesisDto.class));
        return "redirect:/theses";
    }

    @GetMapping("/edit-thesis/{id}")
    public String showEditThesisForm(Model model, @PathVariable Long id) {
        model.addAttribute("thesis", modelMapper.map(thesisService.getThesisById(id),
                UpdateThesisViewModel.class));
        model.addAttribute("applicationDocuments",thesisService.getThesisApplications());
        return "/theses/edit-thesis";
    }

    @PostMapping("/update/{id}")
    public String updateThesis(@PathVariable long id, @Valid @ModelAttribute("thesis") UpdateThesisViewModel thesis,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/theses/edit-thesis";
        }
        thesisService.updateThesis(id, modelMapper.map(thesis, UpdateThesisDto.class));
        return "redirect:/theses";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable long id) {
        thesisService.deleteThesis(id);
        return "redirect:/theses";
    }


    private ThesisViewModel convertToThesisViewModel(ThesisDto thesisDto) {
        return modelMapper.map(thesisDto, ThesisViewModel.class);
    }
}
