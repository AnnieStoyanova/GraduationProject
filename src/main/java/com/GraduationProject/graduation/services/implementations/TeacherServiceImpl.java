package com.GraduationProject.graduation.services.implementations;

import com.GraduationProject.graduation.data.entity.Teacher;
import com.GraduationProject.graduation.data.repository.TeacherRepository;
import com.GraduationProject.graduation.dto.*;
import com.GraduationProject.graduation.services.TeacherService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;
    
    private final ModelMapper modelMapper;

    @Override
    public List<TeacherDto> getTeachers() {
        return teacherRepository.findAll().stream()
                .map(this::convertToTeacherDto)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDto getTeacherById(long id) {
        return modelMapper.map(teacherRepository.findById(id), TeacherDto.class);
    }

    @Override
    public CreateTeacherDto createTeacher(CreateTeacherDto createTeacherDto) {
        return modelMapper.map(
                teacherRepository.save(
                        modelMapper.map(createTeacherDto, Teacher.class)), CreateTeacherDto.class);
    }

    @Override
    public UpdateTeacherDto updateTeacher(long id, UpdateTeacherDto updateTeacherDto) {
        Teacher teacher = modelMapper.map(getTeacherById(id), Teacher.class);
        teacher.setFirstName(updateTeacherDto.getFirstName());
        teacher.setLastName(updateTeacherDto.getLastName());
        teacher.setPosition(updateTeacherDto.getPosition());
        return modelMapper.map(teacherRepository.save(teacher), UpdateTeacherDto.class);

    }

    @Override
    public void deleteTeacher(long id) {
        teacherRepository.deleteById(id);
    }


    private TeacherDto convertToTeacherDto(Teacher teacher) {
        return modelMapper.map(teacher, TeacherDto.class);
    }

}
