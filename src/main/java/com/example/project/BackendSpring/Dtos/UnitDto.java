package com.example.project.BackendSpring.Dtos;

import java.util.Date;
import java.util.UUID;

public class UnitDto {
    private UUID Id;
    private UUID ParentId;
    private UUID CreatedBy;
    private String UnitName;
    private String UnitCode;
    private Integer Status;
    private Boolean IsHide;
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
