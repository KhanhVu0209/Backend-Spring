package com.example.project.BackendSpring.Services.Interfaces;

import com.example.project.BackendSpring.Models.UserType;

public interface UserTypeInterFace {
    UserType GetUserTypeByCode(String typeCode);
}
