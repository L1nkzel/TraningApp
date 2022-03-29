package com.example.traningapp.controller;

import com.example.traningapp.dto.DtoConverter;
import com.example.traningapp.dto.MtResponseDto;
import com.example.traningapp.service.MyTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/MyTraining")
public class MyTrainingController {

    @Autowired
    MyTrainingService myTrainingService;

    @Autowired
    DtoConverter dtoConverter;

    @GetMapping
    public List<MtResponseDto> getMyTrainingList(
            @RequestParam(required = false) String uId) {
        return myTrainingService.findAll(uId)
                .stream()
                .map(myTraining -> dtoConverter.entityToTesponseDto(myTraining)).toList();
    }

}
