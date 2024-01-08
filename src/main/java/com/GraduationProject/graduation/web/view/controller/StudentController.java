package com.GraduationProject.graduation.web.view.controller;

import org.springframework.ui.Model;
import com.GraduationProject.graduation.dto.CreateStudentDto;
import com.GraduationProject.graduation.dto.StudentDto;
import com.GraduationProject.graduation.dto.UpdateStudentDto;
import com.GraduationProject.graduation.services.StudentService;
import com.GraduationProject.graduation.web.view.model.CreateStudentViewModel;
import com.GraduationProject.graduation.web.view.model.StudentViewModel;
import com.GraduationProject.graduation.web.view.model.UpdateStudentViewModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final ModelMapper modelMapper;


    @GetMapping
    private String getStudents(Model model) {
        final List<StudentViewModel> students =
                studentService.getStudents().stream()
                        .map(this::convertToStudentViewModel)
                        .collect(Collectors.toList());
        model.addAttribute("students", students);
        return "/students/students";
    }

    @GetMapping("/create-student")
    public String showCreateStudentForm(Model model) {
        model.addAttribute("student", new CreateStudentViewModel());
        return "/students/create-student";
    }

    @PostMapping("/create")
    public String createStudent(@Valid @ModelAttribute("student") CreateStudentViewModel student,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/students/create-student";
        }
        studentService.createStudent(modelMapper.map(student, CreateStudentDto.class));
        return "redirect:/students";
    }

    @GetMapping("/edit-student/{id}")
    public String showEditStudentForm(Model model, @PathVariable Long id) {
        model.addAttribute("student", modelMapper.map(studentService.getStudentById(id),
                UpdateStudentViewModel.class));
        return "/students/edit-student";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable long id, @Valid @ModelAttribute("student") UpdateStudentViewModel student,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/students/edit-student";
        }
        studentService.updateStudent(id, modelMapper.map(student, UpdateStudentDto.class));
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }


    private StudentViewModel convertToStudentViewModel(StudentDto studentDto) {
        return modelMapper.map(studentDto, StudentViewModel.class);
    }


}
