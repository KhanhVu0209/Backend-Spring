package com.example.project.BackendSpring.Services.Interfaces;

import com.example.project.BackendSpring.Dtos.UserDto;
import com.example.project.BackendSpring.Models.User;
import com.example.project.BackendSpring.Utilities.TemplateApi;

import java.util.Optional;
import java.util.UUID;

public interface UserInterface {
    TemplateApi UpdateUser(UserDto UserDto, UUID idUserCurrent, String fullName);
    TemplateApi InsertUser(UserDto UserDto, UUID idUserCurrent, String fullName);
    TemplateApi GetAllUser(int pageNumber, int pageSize);
    TemplateApi GetUserById(UUID IdUser);
    TemplateApi DeleteUser(UUID IdUser, UUID IdUserCurrent, String fullName);
    User GetUserByEmail(String Email);
}
