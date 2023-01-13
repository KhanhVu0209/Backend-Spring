package com.example.project.BackendSpring.Services.Implement;

import com.example.project.BackendSpring.Models.UserRole;
import com.example.project.BackendSpring.Repositories.UserRoleRepository;
import com.example.project.BackendSpring.Services.Interfaces.UserRoleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserRoleService implements UserRoleInterface {
    UserRoleRepository userRoleRepository;
    @Override
    public List<UserRole> listUserRole(UUID idUser) {
        return userRoleRepository.GetAllRoleOfUser(idUser);
    }
}
