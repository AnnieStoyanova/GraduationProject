package com.GraduationProject.graduation.web.api;

import com.GraduationProject.graduation.dto.CreateStudentDto;
import com.GraduationProject.graduation.dto.StudentDto;
import com.GraduationProject.graduation.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentApiController {

    private final StudentService studentService;

    public StudentApiController(StudentService studentService) {
        this.studentService = studentService;
    }

    List<StudentDto> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/create-student")
    public CreateStudentDto createStudent(@RequestBody CreateStudentDto createStudentDto) {
        return this.studentService.createStudent(createStudentDto);
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable long id) {
        return this.studentService.getStudentById(id);
    }


}
