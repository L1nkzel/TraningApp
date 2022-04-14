package com.example.traningapp.repo;

import com.example.traningapp.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {

    List<Users> findByuserName(String uId);
    Optional<Users> findUsersByUserName(String userName);

}
