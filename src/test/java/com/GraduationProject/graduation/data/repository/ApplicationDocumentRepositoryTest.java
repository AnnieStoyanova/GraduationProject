package com.GraduationProject.graduation.data.repository;

import com.GraduationProject.graduation.data.entity.ApplicationDocument;
import com.GraduationProject.graduation.data.entity.Position;
import com.GraduationProject.graduation.data.entity.Student;
import com.GraduationProject.graduation.data.entity.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ApplicationDocumentRepositoryTest {

    @Autowired
    private ApplicationDocumentRepository applicationDocumentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    private ApplicationDocument applicationDocument;

    private Student student;

    private Teacher teacherLeader;

    @BeforeEach
    public void setup() {
        student = new Student();
        student.setFirstName("Ivan");
        student.setLastName("Georgiev");
        student.setFacultyNumber("F199999");
        student.setGraduationClass(2024);

        teacherLeader = new Teacher();
        teacherLeader.setFirstName("Peter");
        teacherLeader.setLastName("Ivanov");
        teacherLeader.setPosition(Position.DOCENT);


        applicationDocument = new ApplicationDocument();
        applicationDocument.setTheme("Exploring the Atlantic Ocean");
        applicationDocument.setPurpose("Prove the existence of molecules");
        applicationDocument.setTasks("Give the water to laboratory and remove the molecules");
        applicationDocument.setTechnologies("Software and laboratory instruments");
        applicationDocument.setStudent(student);
        applicationDocument.setTeacherLeader(teacherLeader);
        applicationDocument.setIsApproved(false);
    }

    @Test
    void getApplicationDocumentByIdTest() {
        // Given
        testEntityManager.persistAndFlush(applicationDocument);

        // When
        Optional<ApplicationDocument> applicationDocumentById = applicationDocumentRepository.findById(applicationDocument.getId());

        // Then
        assertTrue(applicationDocumentById.isPresent());
    }

    @Test
    void findAllByIsApprovedIsTrueTest() {

        ApplicationDocument approvedApplicationDocument1 = new ApplicationDocument();
        approvedApplicationDocument1.setIsApproved(true);
        approvedApplicationDocument1.setTheme("Theme 1");
        testEntityManager.persistAndFlush(approvedApplicationDocument1);

        ApplicationDocument approvedApplicationDocument2 = new ApplicationDocument();
        approvedApplicationDocument2.setIsApproved(true);
        approvedApplicationDocument2.setTheme("Theme 2");
        testEntityManager.persistAndFlush(approvedApplicationDocument2);

        ApplicationDocument notApprovedApplicationDocument3 = new ApplicationDocument();
        notApprovedApplicationDocument3.setIsApproved(false);
        notApprovedApplicationDocument3.setTheme("Theme 3");
        testEntityManager.persistAndFlush(notApprovedApplicationDocument3);

        List<ApplicationDocument> approvedApplicationDocumentsList = Arrays.asList(approvedApplicationDocument1, approvedApplicationDocument2);

        assertIterableEquals(approvedApplicationDocumentsList, applicationDocumentRepository.findAllByIsApprovedIsTrue());




    }

    @Test
    void findAllByIsApprovedIsTrueNoneApprovedTest() {
        testEntityManager.persistAndFlush(applicationDocument);
        assertThat(applicationDocumentRepository.findAllByIsApprovedIsTrue().size()).isEqualTo(0);
    }



    @Test
    void saveApplicationDocumentTest() {
        // Given
        ApplicationDocument applicationDocument = new ApplicationDocument();
        applicationDocument.setTheme("Exploring the oceans");
        applicationDocument.setPurpose("Find new oceans");
        applicationDocument.setStudent(student);
        applicationDocument.setTeacherLeader(teacherLeader);

        // When
        ApplicationDocument savedApplicationDocument = applicationDocumentRepository.save(applicationDocument);

        // Then
        assertThat(savedApplicationDocument).isNotNull();
    }


    @Test
    void updateApplicationDocumentNameTest() {
        // Given
        testEntityManager.persistAndFlush(applicationDocument);

        // When
        applicationDocument.setTheme("Newly updated theme");
        applicationDocumentRepository.save(applicationDocument);

        // Then
        assertThat(applicationDocument.getTheme()).isEqualTo("Newly updated theme");
    }

    @Test
    void deleteApplicationDocumentTest() {
        // Given
        testEntityManager.persistAndFlush(applicationDocument);

        // When
        applicationDocumentRepository.deleteById(applicationDocument.getId());
        Optional<ApplicationDocument> deletedApplicationDocument = applicationDocumentRepository.findById(applicationDocument.getId());

        // Then
        assertTrue(deletedApplicationDocument.isEmpty());
    }
}
