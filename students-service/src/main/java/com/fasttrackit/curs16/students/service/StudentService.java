package com.fasttrackit.curs16.students.service;

import com.fasttrackit.curs16.students.events.EventPublisher;
import com.fasttrackit.curs16.students.model.Student;
import com.fasttrackit.curs16.students.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;
    private final EventPublisher eventPublisher;

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student save(Student student) {
        student.setId(null);
        Student savedStudent = repository.save(student);
        eventPublisher.sendStudentAddedEvent(student);
        return savedStudent;
    }
}
