package com.example.traningapp.service;
import com.example.traningapp.entities.Users;
import com.example.traningapp.repo.UsersRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    UsersRepo usersRepo;


    public List<Users> findAll(String uId) {
        if (uId == null) {
            return usersRepo.findAll();
        } else {
            return usersRepo.findByuserName(uId);
        }
    }

    public Users createUsers(Users user) {
        return usersRepo.save(user);
    }

    public void deleteById(Users id) {
        usersRepo.delete(id);
    }

    public Users updateUsersById(int id, Users updatedUser) {
        Users users = usersRepo.findById(id).orElseThrow();

        BeanUtils.copyProperties(updatedUser, users,"UId");
        return usersRepo.save(users);
    }

    public Users findUsersById(int uId) {
            return usersRepo.findById(uId).orElseThrow();
        }
    }


