package com.example.project.BackendSpring.Payload.UserPayloads;

import java.util.UUID;

public class GetUserResponse {
    private Object data;
    private Object[] listRole;
    private Boolean Success;
    private String Message;
    private Boolean IsAdmin;

    public GetUserResponse(Object data, Object[] listRole, Boolean success, String message, Boolean isAdmin) {
        this.data = data;
        this.listRole = listRole;
        Success = success;
        Message = message;
        IsAdmin = isAdmin;
    }

    public GetUserResponse(Boolean success, String message) {
        Success = success;
        Message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object[] getListRole() {
        return listRole;
    }

    public void setListRole(Object[] listRole) {
        this.listRole = listRole;
    }

    public Boolean getSuccess() {
        return Success;
    }

    public void setSuccess(Boolean success) {
        Success = success;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Boolean getAdmin() {
        return IsAdmin;
    }

    public void setAdmin(Boolean admin) {
        IsAdmin = admin;
    }
}
