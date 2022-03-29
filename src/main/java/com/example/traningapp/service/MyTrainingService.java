package com.example.traningapp.service;

import com.example.traningapp.entities.MyTraining;
import com.example.traningapp.repo.MyTrainingRepo;
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
}
