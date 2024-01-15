package com.GraduationProject.graduation.services.implementations;

import com.GraduationProject.graduation.data.entity.Position;
import com.GraduationProject.graduation.data.entity.Teacher;
import com.GraduationProject.graduation.data.repository.TeacherRepository;
import com.GraduationProject.graduation.dto.TeacherDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TeacherServiceImplTest {

    @Mock
    private TeacherRepository teacherRepository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private TeacherServiceImpl teacherService;

    private Teacher teacher;

    @BeforeEach
    public void init() {
        teacher = new Teacher();
        teacher.setId(1L);
        teacher.setFirstName("Ivan");
        teacher.setLastName("Georgiev");
        teacher.setPosition(Position.ASSISTANT);
        teacherRepository.save(teacher);
    }

    @Test
    void getTeacherById() {
        // given
        given(teacherRepository.findById(1L))
                .willReturn(Optional.of(teacher));

        // when
        TeacherDto teacherDto =
                teacherService.
                        getTeacherById(teacher.getId());

        // then
        assertThat(teacherDto.getId()).isEqualTo(teacher.getId());
    }
}
