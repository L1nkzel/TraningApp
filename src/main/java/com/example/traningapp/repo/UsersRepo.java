package com.example.traningapp.repo;

import com.example.traningapp.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Integer> {
}
