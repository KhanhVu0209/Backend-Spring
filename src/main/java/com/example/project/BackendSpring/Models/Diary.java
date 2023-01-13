package com.example.project.BackendSpring.Models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class Diary {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private UUID id;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "userid")
    private UUID userId;
    @Basic
    @Column(name = "datecreate")
    private Date dateCreate;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "operation")
    private String operation;
    @Basic
    @Column(name = "table")
    private String table;
    @Basic
    @Column(name = "issuccess")
    private Boolean isSuccess;
    @Basic
    @Column(name = "username")
    private String userName;
    @Basic
    @Column(name = "withid")
    private UUID withId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UUID getWithId() {
        return withId;
    }

    public void setWithId(UUID withId) {
        this.withId = withId;
    }
}
