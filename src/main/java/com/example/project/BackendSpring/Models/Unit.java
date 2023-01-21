package com.example.project.BackendSpring.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="`unit`")
public class Unit {
    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private UUID id;
    @Column(name = "unitname", columnDefinition = "varchar(MAX)")
    private String unitname;
    @Column(name = "parentid", columnDefinition = "uniqueidentifier")
    private UUID parentid;
    @Column(name = "status")
    private Integer status;
    @Column(name = "createdby", columnDefinition = "uniqueidentifier")
    private UUID createdby;
    @Column(name = "createddate")
    private Date createddate;
    @Column(name = "unitcode", columnDefinition = "varchar(MAX)")
    private String unitcode;
    @Column(name = "ishide")
    private Boolean ishide;
}
