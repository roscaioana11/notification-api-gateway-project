package com.fasttrackit.curs16.students.repository;

import com.fasttrackit.curs16.students.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
