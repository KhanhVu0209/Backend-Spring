package com.example.project.BackendSpring.Payload.UserPayloads;

import java.util.UUID;

public class UserLoginResponse {
    private UUID Id;
    private Boolean Success;
    private Boolean Fail;
    private String Message;
    private Object Data;
    private Object[] RoleList;
    private Boolean IsAdmin;


    public UserLoginResponse(UUID id, Boolean success, Boolean fail, String message, Object data, Object[] roleList, Boolean isAdmin) {
        Id = id;
        Success = success;
        Fail = fail;
        Message = message;
        Data = data;
        RoleList = roleList;
        IsAdmin = isAdmin;
    }

    public UserLoginResponse() {
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

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    public Object[] getRoleList() {
        return RoleList;
    }

    public void setRoleList(Object[] roleList) {
        RoleList = roleList;
    }

    public Boolean getAdmin() {
        return IsAdmin;
    }

    public void setAdmin(Boolean admin) {
        IsAdmin = admin;
    }
}
