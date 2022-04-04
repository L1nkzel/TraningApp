package com.example.traningapp.service;

import com.example.traningapp.entities.MyTraining;
import com.example.traningapp.repo.MyTrainingRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MyTrainingService {

    @Autowired
    MyTrainingRepo myTrainingRepo;

    public List<MyTraining>findAll() {
//        if (uId == null) {
//            return myTrainingRepo.findAll();
//        } else {
//            return myTrainingRepo.findByUsers_uId(uId);
//        }
        return myTrainingRepo.findAll();
    }

    public MyTraining findExerciseById(int id) {
        return myTrainingRepo.findById(id).orElseThrow();
    }

    public MyTraining createExercise(MyTraining myTraining) {
        return myTrainingRepo.save(myTraining);
    }

    public void deleteById(int id) {
        myTrainingRepo.deleteById(id);
    }

    public MyTraining updateExerciseById(int id, MyTraining updatedExercise) {
            MyTraining myTraining = myTrainingRepo.findById(id).orElseThrow();

            BeanUtils.copyProperties(updatedExercise, myTraining,"id");
            return myTrainingRepo.save(myTraining);

        }
}
