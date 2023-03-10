package com.example.project.BackendSpring.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class UserDto {
    private UUID id;
    private String fullname;
    private String description;
    @JsonIgnore
    private String password;
    private String email;
    private String phone;
    private UUID usertypeid;
    private String address;
    private Integer status;
    private Date createddate;
    private String usercode;
    private Boolean islocked;
    private Boolean isdeleted;
    private UUID unitid;
    private Boolean isactive;
    @JsonIgnore
    private UUID createdby;
    private String activecode;
    private String avatar;
    @JsonIgnore
    private UUID idrole;
}
