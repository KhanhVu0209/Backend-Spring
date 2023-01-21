package com.example.project.BackendSpring.Repositories;

import com.example.project.BackendSpring.Models.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, UUID> {
    @Query(value = "select * from [dbo].[UserType] where TypeCode = :typeCode", nativeQuery = true)
    UserType getUserTypeByCode(String typeCode);
}
