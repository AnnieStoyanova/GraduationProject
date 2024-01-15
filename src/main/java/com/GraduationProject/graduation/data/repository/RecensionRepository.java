package com.GraduationProject.graduation.data.repository;

import com.GraduationProject.graduation.data.entity.Recension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecensionRepository extends JpaRepository<Recension, Long> {

    long countByDecisionIsFalse();
}
