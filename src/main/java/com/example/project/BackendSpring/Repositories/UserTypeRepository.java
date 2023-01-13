package com.example.project.BackendSpring.Repositories;

import com.example.project.BackendSpring.Models.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserTypeRepository extends JpaRepository<UserType, UUID> {
}
