package com.example.traningapp.service;

import com.example.traningapp.entities.MyTraining;
import com.example.traningapp.repo.MyTrainingRepo;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyTrainingService {

    @Autowired
    MyTrainingRepo myTrainingRepo;

    public List<MyTraining>findAll(String uId) {
        if (uId == null) {
            return myTrainingRepo.findAll();
        } else {
            return myTrainingRepo.findByUsers_uId(uId);
        }
    }

    public MyTraining findExerciseById(int id) {
        return myTrainingRepo.findById(id).orElseThrow();
    }

    public MyTraining createExercise(MyTraining myTrainingIn) {
        return myTrainingRepo.save(myTrainingIn);
    }

    public void deleteById(MyTraining id) {
        myTrainingRepo.delete(id);
    }

    public MyTraining updateExerciseById(int id, MyTraining updatedExercise) {
            MyTraining myTraining = myTrainingRepo.findById(id).orElseThrow();

            BeanUtils.copyProperties(updatedExercise, myTraining,"id");
            return myTrainingRepo.save(myTraining);

        }
}
