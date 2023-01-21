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
@Table(name="`usertype`")
public class UserType {
    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private UUID id;
    @Column(name = "typename")
    private String typename;
    @Column(name = "status")
    private Integer status;
    @Column(name = "createby", columnDefinition = "uniqueidentifier")
    private UUID createby;
    @Column(name = "createdate")
    private Date createdate;
    @Column(name = "typecode")
    private String typecode;
}
