package com.example.project.BackendSpring.Services.Implement;

import com.example.project.BackendSpring.Models.Role;
import com.example.project.BackendSpring.Repositories.RoleRepository;
import com.example.project.BackendSpring.Services.Interfaces.RoleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements RoleInterface {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public Role roleByRoleCode(String roleCode) {
        return roleRepository.findRoleByRoleCode(roleCode);
    }
}
