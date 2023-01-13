package com.example.project.BackendSpring.Repositories;

import com.example.project.BackendSpring.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
    Optional<User> findUserByEmail(String email);
}
