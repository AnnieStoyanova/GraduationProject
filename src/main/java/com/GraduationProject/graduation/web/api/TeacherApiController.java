package com.GraduationProject.graduation.web.api;


import com.GraduationProject.graduation.dto.CreateTeacherDto;
import com.GraduationProject.graduation.dto.TeacherDto;
import com.GraduationProject.graduation.exceptions.StudentNotFoundException;
import com.GraduationProject.graduation.exceptions.TeacherNotFoundException;
import com.GraduationProject.graduation.services.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    @ResponseStatus(HttpStatus.CREATED)
    public CreateTeacherDto createTeacher(@RequestBody CreateTeacherDto createTeacherDto) {
        return this.teacherService.createTeacher(createTeacherDto);
    }

    @GetMapping("/{id}")
    public TeacherDto getTeacherById(@PathVariable long id) {
        try {
            return this.teacherService.getTeacherById(id);
        } catch (TeacherNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Teacher Not Found", ex);
        }
    }

}
