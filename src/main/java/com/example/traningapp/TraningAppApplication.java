package com.example.traningapp;

import com.example.traningapp.entities.MyTraining;
import com.example.traningapp.entities.Users;
import com.example.traningapp.repo.MyTrainingRepo;
import com.example.traningapp.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TraningAppApplication implements CommandLineRunner {

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    MyTrainingRepo myTrainingRepo;

    public static void main(String[] args) {
        SpringApplication.run(TraningAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        Users xherald = new Users("Charli", "charli@hotmail.com");
//        usersRepo.save(xherald);

//        Users user = usersRepo.findById(3).orElseThrow();
//
//
//        MyTraining myTraining = new MyTraining("Axelpress",12,3,user);
//        myTrainingRepo.save(myTraining);
    }
}
