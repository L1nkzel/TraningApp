package com.example.traningapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TraningAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraningAppApplication.class, args);
    }

}
