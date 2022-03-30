package com.example.traningapp.repo;

import com.example.traningapp.entities.MyTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MyTrainingRepo extends JpaRepository<MyTraining, Integer > {

    List<MyTraining> findByUsers_uId(String uId);
}
