package com.example.project.BackendSpring.Dtos;

import jakarta.persistence.Column;

import java.util.Date;
import java.util.UUID;

public class UnitDto {
    private UUID id;
    private String unitname;
    private UUID parentid;
    private Integer status;
    private UUID createdby;
    private Date createddate;
    private String unitcode;
    private Boolean ishide;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public UUID getParentid() {
        return parentid;
    }

    public void setParentid(UUID parentid) {
        this.parentid = parentid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UUID getCreatedby() {
        return createdby;
    }

    public void setCreatedby(UUID createdby) {
        this.createdby = createdby;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }

    public Boolean getIshide() {
        return ishide;
    }

    public void setIshide(Boolean ishide) {
        this.ishide = ishide;
    }
}
