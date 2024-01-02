package com.GraduationProject.graduation.web.view.controller;


import com.GraduationProject.graduation.dto.CreateTeacherDto;
import com.GraduationProject.graduation.dto.TeacherDto;
import com.GraduationProject.graduation.dto.UpdateTeacherDto;
import com.GraduationProject.graduation.services.TeacherService;
import com.GraduationProject.graduation.web.view.model.CreateTeacherViewModel;
import com.GraduationProject.graduation.web.view.model.TeacherViewModel;
import com.GraduationProject.graduation.web.view.model.UpdateTeacherViewModel;
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
@RequestMapping("/teachers")
public class TeacherController {
    
    private final TeacherService teacherService;
    private final ModelMapper modelMapper;


    @GetMapping
    private String getTeachers(Model model) {
        final List<TeacherViewModel> teachers =
                teacherService.getTeachers().stream()
                        .map(this::convertToTeacherViewModel)
                        .collect(Collectors.toList());
        model.addAttribute("teachers", teachers);
        return "/teachers/teachers";
    }

    @GetMapping("/create-teacher")
    public String showCreateTeacherForm(Model model) {
        model.addAttribute("teacher", new CreateTeacherViewModel());
        return "/teachers/create-teacher";
    }

    @PostMapping("/create")
    public String createTeacher(@Valid @ModelAttribute("teacher") CreateTeacherViewModel teacher,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/teachers/create-teacher";
        }
        teacherService.createTeacher(modelMapper.map(teacher, CreateTeacherDto.class));
        return "redirect:/teachers";
    }

    @GetMapping("/edit-teacher/{id}")
    public String showEditTeacherForm(Model model, @PathVariable Long id) {
        model.addAttribute("teacher", modelMapper.map(teacherService.getTeacherById(id),
                UpdateTeacherViewModel.class));
        return "/teachers/edit-teacher";
    }

    @PostMapping("/update/{id}")
    public String updateTeacher(@PathVariable long id, @Valid @ModelAttribute("teacher") UpdateTeacherViewModel teacher,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/teachers/edit-teacher";
        }
        teacherService.updateTeacher(id, modelMapper.map(teacher, UpdateTeacherDto.class));
        return "redirect:/teachers";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable long id) {
        teacherService.deleteTeacher(id);
        return "redirect:/teachers";
    }


    private TeacherViewModel convertToTeacherViewModel(TeacherDto teacherDto) {
        return modelMapper.map(teacherDto, TeacherViewModel.class);
    }
}
