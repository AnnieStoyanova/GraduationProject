package com.GraduationProject.graduation.data.repository;

import com.GraduationProject.graduation.data.entity.ThesisPresentation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDate;

public interface ThesisPresentationRepository extends JpaRepository<ThesisPresentation, Long> {

    List<ThesisPresentation> findByPresentationDateBetweenAndPresentationInfos_GradeNot(
            LocalDate startDate, LocalDate endDate, Double grade);


    // not working:
   long countPresentationInfosByPresentationDateBetween(LocalDate startDate, LocalDate endDate);


}
