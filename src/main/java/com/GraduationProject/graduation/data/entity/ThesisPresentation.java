package com.GraduationProject.graduation.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "thesisPresentation")
public class ThesisPresentation extends BaseEntity {

    @OneToMany
    private List<PresentationInfo> presentationInfos;
    @OneToMany
    private List<Teacher> commission;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate presentationDate;

}

