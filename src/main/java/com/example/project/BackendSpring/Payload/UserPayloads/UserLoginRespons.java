package com.example.project.BackendSpring.Payload.UserPayloads;

import com.example.project.BackendSpring.Models.ListRoleOfUser;
import java.util.UUID;

public class UserLoginRespons {
    private UUID Id;
    private Boolean Success;
    private Boolean Fail;
    private String Message;
    private TokenModel Data;
    private ListRoleOfUser RoleList;
    public UserLoginRespons() {
    }

    public UserLoginRespons(UUID id, Boolean success, Boolean fail, String message, TokenModel data, ListRoleOfUser roleList) {
        Id = id;
        Success = success;
        Fail = fail;
        Message = message;
        Data = data;
        RoleList = roleList;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public Boolean getSuccess() {
        return Success;
    }

    public void setSuccess(Boolean success) {
        Success = success;
    }

    public Boolean getFail() {
        return Fail;
    }

    public void setFail(Boolean fail) {
        Fail = fail;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public TokenModel getData() {
        return Data;
    }

    public void setData(TokenModel data) {
        Data = data;
    }

    public ListRoleOfUser getRoleList() {
        return RoleList;
    }

    public void setRoleList(ListRoleOfUser roleList) {
        RoleList = roleList;
    }
}
