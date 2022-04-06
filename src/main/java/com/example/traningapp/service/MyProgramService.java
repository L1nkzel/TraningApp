package com.example.traningapp.service;

import com.example.traningapp.entities.MyProgram;
import com.example.traningapp.repo.MyProgramRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyProgramService {

    @Autowired
    MyProgramRepo myProgramRepo;

    public List<MyProgram>findAll(){
        return myProgramRepo.findAll();
    }

    public MyProgram createProgram(MyProgram myProgram){
        return myProgramRepo.save(myProgram);
    }

    public void deleteById(int id){
        myProgramRepo.deleteById(id);
    }

    public MyProgram updateProgramById(int id, MyProgram updatedMyProgram){
        MyProgram myProgram = myProgramRepo.findById(id).orElseThrow();
        BeanUtils.copyProperties(updatedMyProgram,myProgram, "mpId");
        return myProgramRepo.save(myProgram);
    }

    public List<MyProgram> findProgramByMyTrainingExercise(String name){
        return myProgramRepo.findByMyTraining_Exercise(name);
    }

}
