package com.GraduationProject.graduation.services;

import com.GraduationProject.graduation.dto.CreateStudentDto;
import com.GraduationProject.graduation.dto.StudentDto;
import com.GraduationProject.graduation.dto.UpdateStudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDto> getStudents();

    StudentDto getStudentById();

    StudentDto getStudentById(long id);

    CreateStudentDto createStudent(CreateStudentDto createStudentDto);

    UpdateStudentDTO updateStudent(long id, UpdateStudentDTO updateStudentDto );
}
