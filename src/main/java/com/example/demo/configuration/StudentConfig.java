package com.example.demo.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig{

   /** @Bean
    CommandLineRunner commandLineRunner( StudentRepository repository){
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    "mariam@yahoo.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            Student alex = new Student(
                    "Alex",
                    "alex@yahoo.com",
                    LocalDate.of(2005, Month.JANUARY, 7)
            );
        repository.saveAll(List.of(mariam,alex));
        };
    }
   */
}