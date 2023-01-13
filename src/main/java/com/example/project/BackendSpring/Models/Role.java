package com.example.project.BackendSpring.Models;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
public class Role {
    @Id
    @Column(name = "id")
    private UUID Id;
    @Basic
    @Column(name = "rolename")
    private String roleName;
    @Basic
    @Column(name = "status")
    private Integer status;
    @Basic
    @Column(name = "isdeleted")
    private boolean isDeleted;
    @Basic
    @Column(name = "isadmin")
    private Boolean isAdmin;
    @Basic
    @Column(name = "numberrole")
    private Integer numberRole;
    @Basic
    @Column(name = "rolecode")
    private String roleCode;

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        this.Id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Integer getNumberRole() {
        return numberRole;
    }

    public void setNumberRole(Integer numberRole) {
        this.numberRole = numberRole;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
