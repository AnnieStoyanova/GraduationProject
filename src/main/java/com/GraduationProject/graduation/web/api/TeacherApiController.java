package com.GraduationProject.graduation.web.api;


import com.GraduationProject.graduation.dto.CreateTeacherDto;
import com.GraduationProject.graduation.dto.TeacherDto;
import com.GraduationProject.graduation.services.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/teachers")
public class TeacherApiController {

    private final TeacherService teacherService;

    public TeacherApiController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    List<TeacherDto> getTeachers() {
        return teacherService.getTeachers();
    }

    @PostMapping("/create-teacher")
    public CreateTeacherDto createTeacher(@RequestBody CreateTeacherDto createTeacherDto) {
        return this.teacherService.createTeacher(createTeacherDto);
    }

    @GetMapping("/{id}")
    public TeacherDto getTeacherById(@PathVariable long id) {
        return this.teacherService.getTeacherById(id);
    }

}
