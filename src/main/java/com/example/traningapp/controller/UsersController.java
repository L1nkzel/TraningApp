//package com.example.traningapp.controller;
//
//import com.example.traningapp.dto.*;
//import com.example.traningapp.entities.MyTraining;
//import com.example.traningapp.entities.Users;
//import com.example.traningapp.service.UsersService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/Users")
//public class UsersController {
//
//    @Autowired
//    UsersService usersService;
//
//    @Autowired
//    DtoConverter dtoConverter;
//
//    @GetMapping
//    public List<UserResponseDto> getUsers(
//            @RequestParam(required = false) String uId) {
//        return usersService.findAll(uId)
//                .stream()
//                .map(users -> dtoConverter.entityToResponseDtoUser(users))
//                .toList();
//    }
//
//    @GetMapping("/{id}")
//    public UserResponseDto getUsersById(@PathVariable("id") int uId) {
//        Users users = usersService.findUsersById(uId);
//        return dtoConverter.entityToResponseDtoUser(users);
//    }
//
//
//    @PostMapping
//    public Users createNewUser(@RequestBody UserRequestDto userRequestDto){
//       Users userIn = dtoConverter.requestDtoToEntityUser(userRequestDto);
//        Users userOut = usersService.createUsers(userIn);
//        return usersService.createUsers(userOut);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteUsersById(@PathVariable("id") Users id){
//        usersService.deleteById(id);
//    }
//
//    @PutMapping("/{id}")
//    public UserResponseDto updateUser(
//            @PathVariable("id") int id,
//            @RequestBody UserRequestDto updatedUserDto) {
//        Users updatedUser = dtoConverter.requestDtoToEntityUser(updatedUserDto);
//
//        Users userOut = usersService.updateUsersById(id, updatedUser);
//        return dtoConverter.entityToResponseDtoUser(userOut);
//    }
//
//
//}
