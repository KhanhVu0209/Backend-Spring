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
    private String unitname;
    @Column(name = "parentid")
    private UUID parentid;
    @Column(name = "status")
    private Integer status;
    @Column(name = "createdby")
    private UUID createdby;
    @Column(name = "createddate")
    private Date createddate;
    @Column(name = "unitcode")
    private String unitcode;
    @Column(name = "ishide")
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
