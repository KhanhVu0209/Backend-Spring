package com.example.project.BackendSpring.Repositories;

import com.example.project.BackendSpring.Models.ListRoleOfUser;
import com.example.project.BackendSpring.Models.Role;
import com.example.project.BackendSpring.Models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
    @Query(value = "SELECT * FROM User_Role u WHERE u.IdUser = :idusers", nativeQuery = true)
    List<UserRole> GetAllRoleOfUser (@Param("idusers") UUID idUser);

    @Query(value = "SELECT r.Id 'IdRole', r.RoleName 'NameRole', u.Id 'IdUser', IIF(r.RoleCode = 'AD', 1, 0) 'IsAdmin'  FROM [dbo].[User] u left join User_Role ur on u.Id = ur.IdUser left join Role r on r.Id = ur.IdRole where u.Id = :idusers", nativeQuery = true)
    ListRoleOfUser GetAllInforRoleOfUser (@Param("idusers") UUID idUser);
}
