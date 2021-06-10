package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner (StudentRepository repository){
        return args -> {
            Student yasin = new Student(
                "yasin",
                "muhyasin89@gmail.com",
                LocalDate.of(2000, Month.JANUARY, 5),
                21
            );

            Student alex = new Student(
                "alex",
                "alex@gmail.com",
                LocalDate.of(2011, Month.MAY, 19),
                18
            );

            Student jody = new Student(
                "jody",
                "jody@gmail.com",
                LocalDate.of(2002, Month.MAY, 19),
                19
            );

            Student diana = new Student(
                "diana",
                "diana@gmail.com",
                LocalDate.of(2001, Month.MAY, 19),
                20
            );

            repository.saveAll(
                List.of(yasin, alex, jody, diana)
            );
        };
    }
}
