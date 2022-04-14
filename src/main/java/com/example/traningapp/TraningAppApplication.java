package com.example.traningapp;

import com.example.traningapp.entities.MyTraining;
import com.example.traningapp.entities.Role;
import com.example.traningapp.entities.Users;
import com.example.traningapp.repo.MyTrainingRepo;
import com.example.traningapp.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;


@SpringBootApplication
@EnableJpaAuditing
public class TraningAppApplication implements CommandLineRunner {

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    MyTrainingRepo myTrainingRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(TraningAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//       Users charli = new Users("Charli",passwordEncoder.encode("passs"), "charli@hotmail.com", Role.ADMIN);
//       Users ali = new Users("Ali",passwordEncoder.encode("pass"), "ALI@hotmail.com", Role.USER);
//       Users sara = new Users("Sara",passwordEncoder.encode("pass"), "Sara@hotmail.com", Role.USER);


//        usersRepo.saveAll(List.of(charli,ali,sara));

//        Users user = usersRepo.findById(3).orElseThrow();
//
//
//        MyTraining myTraining = new MyTraining("Axelpress",12,3,user);
//        myTrainingRepo.save(myTraining);
    }
}
