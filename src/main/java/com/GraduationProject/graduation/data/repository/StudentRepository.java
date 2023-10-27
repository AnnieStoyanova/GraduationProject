package com.GraduationProject.graduation.data.repository;

import com.GraduationProject.graduation.data.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
