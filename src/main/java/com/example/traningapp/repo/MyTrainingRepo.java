package com.example.traningapp.repo;

import com.example.traningapp.entities.MyTraining;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyTrainingRepo extends JpaRepository<MyTraining, Integer > {

    List<MyTraining> findByUsers_uId(String uId);
}
