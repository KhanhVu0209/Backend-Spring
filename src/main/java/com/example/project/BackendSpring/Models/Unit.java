package com.example.project.BackendSpring.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "Unit")
public class Unit {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID Id;
    @jakarta.persistence.Column(name = "ParentId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ParentId;
    @jakarta.persistence.Column(name = "CreatedBy")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID CreatedBy;
    @jakarta.persistence.Column(name = "UnitName")
    private String UnitName;
    @jakarta.persistence.Column(name = "UnitCode")
    private String UnitCode;
    @jakarta.persistence.Column(name = "Status")
    private Integer Status;
    @jakarta.persistence.Column(name = "IsHide")
    private Boolean IsHide;
    @jakarta.persistence.Column(name = "CreatedDate")
    private Date CreatedDate;

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public UUID getParentId() {
        return ParentId;
    }

    public void setParentId(UUID parentId) {
        ParentId = parentId;
    }

    public UUID getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(UUID createdBy) {
        CreatedBy = createdBy;
    }

    public String getUnitName() {
        return UnitName;
    }

    public void setUnitName(String unitName) {
        UnitName = unitName;
    }

    public String getUnitCode() {
        return UnitCode;
    }

    public void setUnitCode(String unitCode) {
        UnitCode = unitCode;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public Boolean getHide() {
        return IsHide;
    }

    public void setHide(Boolean hide) {
        IsHide = hide;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }
}
