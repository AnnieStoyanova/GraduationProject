package com.GraduationProject.graduation.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "thesisPresentation")
public class ThesisPresentation extends BaseEntity {

    @OneToMany
    private List<Thesis> thesisList;
    @OneToMany
    private List<Teacher> commission;
    private Date presentationDate;
    @OneToMany
    private List<PresentationInfo> results;

}

