package com.example.traningapp.dto;

import com.example.traningapp.entities.MyTraining;
import com.example.traningapp.entities.Users;
import com.example.traningapp.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtoConverter {

    @Autowired
    UsersRepo usersRepo;


    public MyTraining requestDtoToEntity(MtRequestDto mtRequestDto){

        Users users = usersRepo.findById(mtRequestDto.uId()).orElseThrow();

        return new MyTraining(
                mtRequestDto.exercise(),
                mtRequestDto.numRep(),
                mtRequestDto.numSet(),
                users
        );
    }

    public MtResponseDto entityToResponseDto(MyTraining myTraining){
        return new MtResponseDto(
                myTraining.getId(),
                myTraining.getExercise(),
                myTraining.getNumRep(),
                myTraining.getNumSet(),
                myTraining.getUsers().getUId()
        );
    }
}
