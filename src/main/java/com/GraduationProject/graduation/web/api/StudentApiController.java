package com.GraduationProject.graduation.web.api;

import com.GraduationProject.graduation.dto.StudentDto;
import com.GraduationProject.graduation.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentApiController {

    private final StudentService studentService;
    List<StudentDto> getStudents() {
        return studentService.getStudents();
    }
}
