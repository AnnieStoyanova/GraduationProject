package com.GraduationProject.graduation.services;

import com.GraduationProject.graduation.dto.CreateStudentDto;
import com.GraduationProject.graduation.dto.StudentDto;
import com.GraduationProject.graduation.dto.UpdateStudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getStudents();

    StudentDto getStudentById(long id);

    CreateStudentDto createStudent(CreateStudentDto createStudentDto);

    UpdateStudentDto updateStudent(long id, UpdateStudentDto updateStudentDto );

    void deleteStudent(long id);
}
