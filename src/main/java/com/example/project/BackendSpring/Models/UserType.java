package com.example.project.BackendSpring.Models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class UserType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private UUID id;
    @Basic
    @Column(name = "typename")
    private String typeName;
    @Basic
    @Column(name = "status")
    private Integer status;
    @Basic
    @Column(name = "createby")
    private UUID createBy;
    @Basic
    @Column(name = "createdate")
    private Date createDate;
    @Basic
    @Column(name = "typecode")
    private String typeCode;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UUID getCreateBy() {
        return createBy;
    }

    public void setCreateBy(UUID createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
}
