package com.fasttrackit.curs16.students.controller;

import com.fasttrackit.curs16.students.model.Student;
import com.fasttrackit.curs16.students.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping
    List<Student> getAll() {
        return service.getAll();
    }

    @PostMapping
    Student saveStudent(@RequestBody Student student) {
        return service.save(student);
    }

}
