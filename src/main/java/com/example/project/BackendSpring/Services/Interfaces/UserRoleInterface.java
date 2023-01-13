package com.example.project.BackendSpring.Services.Interfaces;

import com.example.project.BackendSpring.Models.ListRoleOfUser;
import com.example.project.BackendSpring.Models.UserRole;

import java.util.List;
import java.util.UUID;

public interface UserRoleInterface {
    List<UserRole> listUserRole (UUID idUser);
    ListRoleOfUser GetAllInforRoleOfUser(UUID idUUser);
}
