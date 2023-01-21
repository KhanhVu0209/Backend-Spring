package com.example.project.BackendSpring.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="`diary`")
public class Diary {
    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private UUID id;
    @Column(name = "contentdiary")
    private String contentdiary;
    @Column(name = "userid", columnDefinition = "uniqueidentifier")
    private UUID userid;
    @Column(name = "datecreate")
    private Date datecreate;
    @Column(name = "title")
    private String title;
    @Column(name = "operation")
    private String operation;
    @Column(name = "tableregardto")
    private String tableregardto;
    @Column(name = "issuccess")
    private Boolean issuccess;
    @Column(name = "username")
    private String username;
    @Column(name = "withid", columnDefinition = "uniqueidentifier")
    private UUID withid;
}
