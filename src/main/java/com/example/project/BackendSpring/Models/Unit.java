package com.example.project.BackendSpring.Models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.UUID;

@Entity
public class Unit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "unitname")
    private String unitName;
    @Column(name = "parentid")

    private UUID parentId;
    @Column(name = "status")

    private Integer status;
    @Column(name = "createdby")
    private UUID createdBy;
    @Column(name = "createddate")

    private Date createdDate;
    @Column(name = "unitcode")

    private String unitCode;
    @Column(name = "ishide")

    private Boolean isHide;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public Boolean getHide() {
        return isHide;
    }

    public void setHide(Boolean hide) {
        isHide = hide;
    }
}
