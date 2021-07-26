package com.fasttrackit.curs16.students;

import com.fasttrackit.curs16.students.model.Student;
import com.fasttrackit.curs16.students.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class StudentsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentsServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(StudentRepository repo) {
        return args -> {
            repo.saveAll(List.of(
                    new Student("Ana"),
                    new Student("Mihai"),
                    new Student("Ioan"),
                    new Student("Gina")
            ));
        };
    }
}
