package com.mydemo.service;

import com.mydemo.model.data.StudentSearchDto;
import com.mydemo.model.entity.Student;
import com.mydemo.model.repo.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hibernate.TransactionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepo;
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    // Save/Update student based on student id
   // @Transactional
    public String saveOrUpdateStudent(Student student) {
        logger.info("Save or update student");
        try {
            if (student.getId() != null && studentRepo.existsById(student.getId())) {
                studentRepo.save(student);
                logger.info("Student updated successfully");
                return "Student updated successfully";
            } else {
                studentRepo.save(student);
                logger.info("Student created successfully");
                return "Student created successfully";
            }
        } catch (TransactionException e) {
            logger.error("Error saving or updating student: {}", e.getMessage());
            return "Error saving or updating student";
        }
    }

    // Delete student based on student id
    @Transactional
    public String deleteStudent(Integer studentID) {
        logger.info("Delete student");
        try {
            studentRepo.deleteById(studentID);
            logger.info("StudentDto deleted successfully");
            return "StudentDto deleted successfully";
        } catch (Exception e) {
            logger.error("Error deleting student: {}", e.getMessage());
            return "Error deleting student";
        }
    }

    // Get student based on student id
    public Student getStudentById(Integer studentID) {
        logger.info("Get student by id");
        try {
            return studentRepo.findById(studentID).orElseThrow(() -> new Exception("not found"));
        } catch (Exception e) {
            logger.error("Error getting student by id: {}", e.getMessage());
            return null;
        }
    }

    public List<Student> getAllStudents() {
        logger.info("List all students");
        try {
            return studentRepo.findAll();
        } catch (Exception e) {
            logger.error("Error listing all students: {}", e.getMessage());
            return List.of();

        }
    }




}
