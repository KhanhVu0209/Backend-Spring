package com.example.project.BackendSpring.Payload.UserPayloads;

import java.util.UUID;

public class InsertUserPayload {
    private UUID id;
    private String fullname;
    private String description;
    private String password;
    private String email;
    private String phone;
    private UUID usertypeid;
    private String address;
    private UUID unitId;

    public UUID getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getDescription() {
        return description;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public UUID getUsertypeid() {
        return usertypeid;
    }

    public String getAddress() {
        return address;
    }

    public UUID getUnitId() {
        return unitId;
    }
}
