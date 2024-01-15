package com.GraduationProject.graduation.data.repository;

import com.GraduationProject.graduation.data.entity.PresentationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PresentationInfoRepository extends JpaRepository<PresentationInfo, Long> {

    List<PresentationInfo> findByGradeBetween(Double startGrade, Double endGrade);

    long countByGradeNotAndThesis_ApplicationDocument_TeacherLeader_Id(Double grade, Long teacherLeaderId);

}
