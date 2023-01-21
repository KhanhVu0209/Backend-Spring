package com.example.project.BackendSpring.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="`role`")
public class Role {
    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private UUID id;
    @Column(name = "rolename")
    private String rolename;
    @Column(name = "status")
    private Integer status;
    @Column(name = "isdeleted")
    private boolean isdeleted;
    @Column(name = "isadmin")
    private Boolean isadmin;
    @Column(name = "numberrole")
    private Integer numberrole;
    @Column(name = "rolecode")
    private String rolecode;
}
