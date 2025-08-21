package com.studentmanagement.repository;

import com.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    Optional<Student> findByEmail(String email);
    
    Optional<Student> findByRollNumber(String rollNumber);
    
    boolean existsByEmail(String email);
    
    boolean existsByRollNumber(String rollNumber);
    
    List<Student> findByCourse(String course);
    
    List<Student> findBySemester(Integer semester);
    
    @Query("SELECT s FROM Student s WHERE s.name LIKE %?1% OR s.email LIKE %?1%")
    List<Student> findByNameOrEmailContaining(String searchTerm);
    
    @Query("SELECT COUNT(s) FROM Student s WHERE s.course = ?1")
    Long countByCourse(String course);
}