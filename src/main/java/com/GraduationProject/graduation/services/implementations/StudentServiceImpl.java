package com.GraduationProject.graduation.services.implementations;

import com.GraduationProject.graduation.data.entity.Student;
import com.GraduationProject.graduation.data.repository.StudentRepository;
import com.GraduationProject.graduation.dto.CreateStudentDto;
import com.GraduationProject.graduation.dto.StudentDto;
import com.GraduationProject.graduation.dto.UpdateStudentDto;
import com.GraduationProject.graduation.services.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getStudents() {
        return studentRepository.findAll().stream()
                .map(this::convertToStudentDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentById(long id) {
        return modelMapper.map(studentRepository.findById(id), StudentDto.class);
    }

    @Override
    public CreateStudentDto createStudent(CreateStudentDto createStudentDto) {
        return modelMapper.map(
                studentRepository.save(
                        modelMapper.map(createStudentDto, Student.class)), CreateStudentDto.class);
    }

    @Override
    public UpdateStudentDto updateStudent(long id, UpdateStudentDto updateStudentDto) {
        Student student = modelMapper.map(getStudentById(id), Student.class);
        student.setFirstName(updateStudentDto.getFirstName());
        student.setLastName(updateStudentDto.getLastName());
        student.setFacultyNumber(updateStudentDto.getFacultyNumber());
        student.setGraduationClass(updateStudentDto.getGraduationClass());
        return modelMapper.map(studentRepository.save(student), UpdateStudentDto.class);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    private StudentDto convertToStudentDto(Student student) {
        return modelMapper.map(student, StudentDto.class);
    }
}
