package com.example.project.BackendSpring.Services.Implement;

import com.example.project.BackendSpring.Models.UserType;
import com.example.project.BackendSpring.Repositories.UserTypeRepository;
import com.example.project.BackendSpring.Services.Interfaces.UserTypeInterFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTypeService implements UserTypeInterFace {
    @Autowired
    UserTypeRepository userTypeRepository;

    @Override
    public UserType GetUserTypeByCode(String typeCode) {
        return userTypeRepository.getUserTypeByCode(typeCode);
    }
}
