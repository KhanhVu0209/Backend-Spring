package com.example.project.BackendSpring.Repositories;

import com.example.project.BackendSpring.Models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
    @Query(value = "SELECT * FROM User_Role u WHERE u.IdUser = :idUser", nativeQuery = true)
    List<UserRole> getAllRoleOfUser (UUID idUser);
    @Query(value = "SELECT * FROM User_Role u WHERE u.IdUser = :idUser and u.IdRole = :idRole", nativeQuery = true)
    UserRole getRoleOfUser (UUID idUser, UUID idRole);

    @Query(value = "SELECT r.Id 'IdRole', r.RoleName 'NameRole', u.Id 'IdUser', IIF(r.RoleCode = 'AD', 1, 0) 'IsAdmin'  FROM [dbo].[User] u left join User_Role ur on u.Id = ur.IdUser left join Role r on r.Id = ur.IdRole where u.Id = :idUser", nativeQuery = true)
    List<Object> getAllInformRoleOfUser(UUID idUser);
}
