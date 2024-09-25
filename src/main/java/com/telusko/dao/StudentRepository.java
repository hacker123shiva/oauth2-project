 

package com.telusko.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.telusko.entity.Student;

// This is the DAO interface for Student
public interface StudentRepository extends JpaRepository<Student, Integer> {
    
}
