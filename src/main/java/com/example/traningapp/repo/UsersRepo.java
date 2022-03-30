package com.example.traningapp.repo;

import com.example.traningapp.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {

    List<Users> findByuserName(String uId);
}
