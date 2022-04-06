package com.example.traningapp.repo;

import com.example.traningapp.entities.MyProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyProgramRepo extends JpaRepository<MyProgram, Integer> {



}
