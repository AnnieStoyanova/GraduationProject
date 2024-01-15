package com.GraduationProject.graduation.web.api;

import com.GraduationProject.graduation.dto.CreateStudentDto;
import com.GraduationProject.graduation.dto.StudentDto;
import com.GraduationProject.graduation.exceptions.StudentNotFoundException;
import com.GraduationProject.graduation.services.implementations.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;


import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentApiController.class)
class StudentApiControllerTest {

    @MockBean
    private StudentServiceImpl studentService;

    @SpyBean
    private ModelMapper modelMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(username = "SYSTEM", authorities = {"ADMIN", "TEACHER"})
    void getStudentByIdTest() throws Exception {
        long studentId = 1L;
        StudentDto student = new StudentDto();
        student.setId(studentId);
        student.setFirstName("Ivan");
        student.setLastName("Georgiev");
        student.setFacultyNumber("F123");

        given(studentService.getStudentById(studentId)).willReturn(student);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/students/{studentId}", studentId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(student.getId()), Long.class))
                .andExpect(jsonPath("$.firstName", is(student.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(student.getLastName())))
                .andExpect(jsonPath("$.facultyNumber", is(student.getFacultyNumber())))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "SYSTEM", authorities = {"ADMIN", "TEACHER"})
    void getStudentByIdNotFoundTest() throws Exception {
        long studentId = 1L;
        StudentDto student = new StudentDto();
        student.setId(studentId);
        student.setFirstName("Peter");
        student.setLastName("Petrov");
        student.setFacultyNumber("F111111");

        long notFoundStudentId = 2;

        given(studentService.getStudentById(notFoundStudentId)).willThrow(new StudentNotFoundException("Student Not Found"));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/students/{studentId}", notFoundStudentId))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("/error/error"));
    }

    @Test
    @WithMockUser(username = "SYSTEM", authorities = {"ADMIN", "TEACHER"})
    void getStudentsTest() throws Exception {
        StudentDto student1 = new StudentDto();
        student1.setId(1L);
        student1.setFirstName("Peter");
        student1.setLastName("Petrov");
        student1.setFacultyNumber("F111111");
        student1.setGraduationClass(2025);

        StudentDto student2 = new StudentDto();
        student2.setId(2L);
        student2.setFirstName("Georgi");
        student2.setLastName("Georgiev");
        student2.setFacultyNumber("F222222");
        student2.setGraduationClass(2024);

        List<StudentDto> studentDtos = Arrays.asList(student1, student2);
        given(studentService.getStudents()).willReturn(studentDtos);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/students"))
                .andExpect(status().isOk())
                .andExpect((jsonPath("$[0].firstName").value(equalTo("Peter"))))
                .andExpect((jsonPath("$[1].firstName").value(equalTo("Georgi"))))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "SYSTEM", authorities = {"ADMIN", "TEACHER"})
    void createSchoolTest() throws Exception {
        CreateStudentDto student = new CreateStudentDto();
        student.setFirstName("Peter");
        student.setLastName("Petrov");
        student.setFacultyNumber("F111111");

        given(studentService.createStudent(any(CreateStudentDto.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/students/create-student")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", is(student.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(student.getLastName())))
                .andExpect(jsonPath("$.facultyNumber", is(student.getFacultyNumber())));
    }
}
