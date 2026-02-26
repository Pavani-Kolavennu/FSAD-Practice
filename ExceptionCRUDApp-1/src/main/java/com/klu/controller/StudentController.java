package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Student;
import com.klu.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
    private StudentService service;

    // CREATE
    @PostMapping("/student/add")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(
                service.createStudent(student),
                HttpStatus.CREATED);
    }

    // READ ALL (Pagination)
    @GetMapping("/student/getall")
    public ResponseEntity<Page<Student>> getAllStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity.ok(
                service.getAllStudents(page, size));
    }

    // READ BY ID
    @GetMapping("/student/getbyid/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(
                service.getStudentById(id));
    }

    // READ BY COURSE (JPQL)
    @GetMapping("/student/course/{course}")
    public ResponseEntity<Page<Student>> getByCourse(
            @PathVariable String course,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity.ok(
                service.getStudentsByCourse(course, page, size));
    }

    // UPDATE
    @PutMapping("/student/update/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        return ResponseEntity.ok(
                service.updateStudent(id, student));
    }

    // DELETE
    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {

        service.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
