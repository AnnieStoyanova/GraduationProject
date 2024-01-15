package com.GraduationProject.graduation.web.api;

import com.GraduationProject.graduation.dto.CreateStudentDto;
import com.GraduationProject.graduation.dto.StudentDto;
import com.GraduationProject.graduation.exceptions.StudentNotFoundException;
import com.GraduationProject.graduation.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/api/students")
public class StudentApiController {

    private final StudentService studentService;

    public StudentApiController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    List<StudentDto> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/create-student")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateStudentDto createStudent(@RequestBody CreateStudentDto createStudentDto) {
        return this.studentService.createStudent(createStudentDto);
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable long id) {
        try {
            return this.studentService.getStudentById(id);
        } catch (StudentNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Student Not Found", ex);
        }
    }


}
