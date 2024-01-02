package com.GraduationProject.graduation.services;

import com.GraduationProject.graduation.dto.CreateTeacherDto;
import com.GraduationProject.graduation.dto.TeacherDto;
import com.GraduationProject.graduation.dto.UpdateTeacherDto;

import java.util.List;

public interface TeacherService {

    List<TeacherDto> getTeachers();

    TeacherDto getTeacherById(long id);

    CreateTeacherDto createTeacher(CreateTeacherDto createTeacherDto);

    UpdateTeacherDto updateTeacher(long id, UpdateTeacherDto updateTeacherDto );

    void deleteTeacher(long id);
}
