package com.GraduationProject.graduation.data.repository;

import com.GraduationProject.graduation.data.entity.ApplicationDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ApplicationDocumentRepository extends JpaRepository<ApplicationDocument, Long> {

    List<ApplicationDocument> findAllByIsApprovedIsTrue();

}
