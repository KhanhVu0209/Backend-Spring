package com.example.project.BackendSpring.Models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.UUID;

@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private UUID id;
    @Basic
    @Column(name = "fullname")
    private String fullname;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "usertypeid")
    private UUID userTypeId;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "status")
    private Integer status;
    @Basic
    @Column(name = "createdDate")
    private Date createdDate;
    @Basic
    @Column(name = "usercode")
    private String userCode;
    @Basic
    @Column(name = "islocked")
    private boolean isLocked;
    @Basic
    @Column(name = "isdeleted")
    private boolean isDeleted;
    @Basic
    @Column(name = "unitid")
    private UUID unitId;
    @Basic
    @Column(name = "isactive")
    private boolean isActive;
    @Basic
    @Column(name = "createdby")
    private UUID createdBy;
    @Basic
    @Column(name = "activecode")
    private String activeCode;
    @Basic
    @Column(name = "avatar")
    private String avatar;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UUID getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(UUID userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public UUID getUnitId() {
        return unitId;
    }

    public void setUnitId(UUID unitId) {
        this.unitId = unitId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
