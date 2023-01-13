package com.example.project.BackendSpring.Payload.UserPayloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginUserRequest {
    private String email;
    private String password;
}
