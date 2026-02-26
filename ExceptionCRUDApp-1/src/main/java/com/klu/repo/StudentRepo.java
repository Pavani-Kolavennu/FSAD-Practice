package com.klu.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.klu.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
	  // JPQL query
    @Query("SELECT s FROM Student s WHERE s.course = :course")
    Page<Student> findByCourse(@Param("course") String course, Pageable pageable);
}
