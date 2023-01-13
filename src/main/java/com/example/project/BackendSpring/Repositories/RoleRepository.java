package com.example.project.BackendSpring.Repositories;

import com.example.project.BackendSpring.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    @Query(value = "SELECT * FROM Role u WHERE u.RoleCode = :rolecode", nativeQuery = true)
    Role findRoleByRoleCode(@Param("rolecode") String rolecode);
}
