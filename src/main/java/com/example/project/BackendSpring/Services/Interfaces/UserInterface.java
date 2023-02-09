package com.example.project.BackendSpring.Services.Interfaces;

import com.example.project.BackendSpring.Dtos.UserDto;
import com.example.project.BackendSpring.Models.User;
import com.example.project.BackendSpring.Utilities.TemplateApi;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserInterface {
    TemplateApi DeleteUserRole(UUID idRole, UUID idUser, UUID idUserCurrent, String fullName);
    TemplateApi AddUserRole(UUID idRole, UUID idUser, UUID idUserCurrent, String fullName);
    TemplateApi UpdateUser(UserDto UserDto, UUID idUserCurrent, String fullName);
    TemplateApi InsertUser(UserDto UserDto, UUID idUserCurrent, String fullName);
    TemplateApi GetAllUser(int pageNumber, int pageSize);
    TemplateApi GetAllUserAvailable(int pageNumber, int pageSize);
    TemplateApi GetUserById(UUID IdUser);
    TemplateApi DeleteUsers(List<UUID> idUsers, UUID IdUserCurrent, String fullName);
    TemplateApi LockUsers(List<UUID> idUsers, UUID IdUserCurrent, String fullName);
    TemplateApi ActiveUserByCode(String email, Boolean code);
    TemplateApi UpdatePassword(String email, String newPassWord);
    User GetUserByEmail(String Email);
    Optional<User> GetUserByEmailOp(String email);
}
