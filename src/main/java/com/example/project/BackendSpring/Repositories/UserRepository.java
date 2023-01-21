package com.example.project.BackendSpring.Repositories;

import com.example.project.BackendSpring.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    @Query(value = "select *from [dbo].[user] where Email = :email", nativeQuery = true)
    User findByEmail(String email);

    Optional<User> findUserByEmail(String email);

    @Query(value = "select *from [dbo].[user] where IsDeleted = 0 and IsLocked = 0 order by CreatedDate desc", nativeQuery = true)
    List<User> getAllUserAvailable();

    @Query(value = "select * from [dbo].[user] where IsDeleted = 0 order by CreatedDate desc", nativeQuery = true)
    List<User> getAllUser();

    @Query(value = "select * from [dbo].[user] where Id in (:ids)", nativeQuery = true)
    List<UUID> getIdUsersByListId(@Param("ids") List<UUID> isUsers);
}
