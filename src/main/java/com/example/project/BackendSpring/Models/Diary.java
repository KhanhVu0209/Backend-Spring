package com.example.project.BackendSpring.Models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "Diary")
public class Diary {
    @jakarta.persistence.Id
    @jakarta.persistence.Column(name = "Id")
    private UUID Id;
    @jakarta.persistence.Column(name = "Content")
    private String Content;
    @jakarta.persistence.Column(name = "UserName")
    private String UserName;
    @jakarta.persistence.Column(name = "Title")
    private String Title;
    @jakarta.persistence.Column(name = "Operation")
    private String Operation;
    @jakarta.persistence.Column(name = "Table")
    private String Table;
    @jakarta.persistence.Column(name = "IsSuccess")
    private boolean IsSuccess;
    @jakarta.persistence.Column(name = "UserId")
    private UUID UserId;
    @jakarta.persistence.Column(name = "WithId")
    private UUID WithId;
    @jakarta.persistence.Column(name = "DateCreate")
    private Date DateCreate;

    public Diary(UUID id, String content, String userName, String title, String operation, String table, boolean isSuccess, UUID userId, UUID withId, Date dateCreate) {
        Id = id;
        Content = content;
        UserName = userName;
        Title = title;
        Operation = operation;
        Table = table;
        IsSuccess = isSuccess;
        UserId = userId;
        WithId = withId;
        DateCreate = dateCreate;
    }

    public Diary() {

    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getOperation() {
        return Operation;
    }

    public void setOperation(String operation) {
        Operation = operation;
    }

    public String getTable() {
        return Table;
    }

    public void setTable(String table) {
        Table = table;
    }

    public boolean isSuccess() {
        return IsSuccess;
    }

    public void setSuccess(boolean success) {
        IsSuccess = success;
    }

    public UUID getUserId() {
        return UserId;
    }

    public void setUserId(UUID userId) {
        UserId = userId;
    }

    public UUID getWithId() {
        return WithId;
    }

    public void setWithId(UUID withId) {
        WithId = withId;
    }

    public Date getDateCreate() {
        return DateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        DateCreate = dateCreate;
    }
}
