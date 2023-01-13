package com.example.project.BackendSpring.Repositories;

import com.example.project.BackendSpring.Models.Role;
import com.example.project.BackendSpring.Models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
    @Query(value = "SELECT * FROM User_Role u WHERE u.IdUser = :idusers", nativeQuery = true)
    List<UserRole> GetAllRoleOfUser (@Param("idusers") UUID idUser);
}
