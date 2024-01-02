package com.GraduationProject.graduation.web.view.model;

import com.GraduationProject.graduation.data.entity.Student;
import com.GraduationProject.graduation.data.entity.Teacher;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationViewModel {

    private long id;
    private String theme;
    private String purpose;
    private String tasks;
    private String technologies;
    private Student student;
    private Teacher teacherLeader;
    private Boolean isApproved;
}
