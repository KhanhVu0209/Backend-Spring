package com.example.project.BackendSpring.Payload.UserPayloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterUserRequest {
    private String email;
    private String fullName;
    private String password;
    private String phone;
    private String address;
}
