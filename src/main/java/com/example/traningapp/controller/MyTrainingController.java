//package com.example.traningapp.controller;
//
//import com.example.traningapp.dto.DtoConverter;
//import com.example.traningapp.dto.MtRequestDto;
//import com.example.traningapp.dto.MtResponseDto;
//import com.example.traningapp.entities.MyTraining;
//import com.example.traningapp.repo.MyTrainingRepo;
//import com.example.traningapp.service.MyTrainingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/MyTraining")
//public class MyTrainingController {
//
//    @Autowired
//    MyTrainingService myTrainingService;
//
//    @Autowired
//    DtoConverter dtoConverter;
//
//    @GetMapping
//    public List<MtResponseDto> getMyTrainingList(
//            @RequestParam(required = false) String uId) {
//        return myTrainingService.findAll(uId)
//                .stream()
//                .map(myTraining -> dtoConverter.entityToResponseDto(myTraining)).toList();
//    }
//
//    @GetMapping("/{id}")
//    public MtResponseDto getExerciseById(@PathVariable("id") int id) {
//        MyTraining myTraining = myTrainingService.findExerciseById(id);
//        return dtoConverter.entityToResponseDto(myTraining);
//    }
//
//    @PostMapping
//    public MtResponseDto addExercise(@RequestBody MtRequestDto mtRequestDto) {
//        MyTraining myTrainingIn = dtoConverter.requestDtoToEntity(mtRequestDto);
//
//        MyTraining myTrainingOut = myTrainingService.createExercise(myTrainingIn);
//        return dtoConverter.entityToResponseDto(myTrainingOut);
//    }
//
//
//    @DeleteMapping("/{id}")
//    public void deleteExerciseById(@PathVariable("id") MyTraining id){
//        myTrainingService.deleteById(id);
//    }
//
//    @PutMapping("/{id}")
//    public MtResponseDto updateExercise(
//            @PathVariable("id") int id,
//            @RequestBody MtRequestDto updatedExerciseDto) {
//        MyTraining updatedExercise = dtoConverter.requestDtoToEntity(updatedExerciseDto);
//
//        MyTraining myTrainingOut = myTrainingService.updateExerciseById(id, updatedExercise);
//        return dtoConverter.entityToResponseDto(myTrainingOut);
//    }
//
//
//
//}
