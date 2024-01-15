package com.GraduationProject.graduation.services.implementations;

import com.GraduationProject.graduation.data.entity.Student;
import com.GraduationProject.graduation.data.repository.StudentRepository;
import com.GraduationProject.graduation.dto.StudentDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Student student;

    @BeforeEach
    public void init() {
        student = new Student();
        student.setId(1L);
        student.setFirstName("Ivan");
        student.setLastName("Georgiev");
        student.setFacultyNumber("F123456");
        student.setGraduationClass(2025);
        studentRepository.save(student);
    }

    @Test
    void getStudentById() {
        // given
        given(studentRepository.findById(1L))
                .willReturn(Optional.of(student));

        // when
        StudentDto studentDto =
                studentService.
                        getStudentById(student.getId());

        // then
        assertThat(studentDto.getId()).isEqualTo(student.getId());
    }
}
