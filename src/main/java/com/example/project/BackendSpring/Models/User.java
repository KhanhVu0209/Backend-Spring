package com.example.project.BackendSpring.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import org.hibernate.annotations.Type;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="`user`")
public class User implements UserDetails {
    @Id
    //@Type(type = "uuid-char")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private UUID id;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "description")
    private String description;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "usertypeid", columnDefinition = "uniqueidentifier")
    private UUID usertypeid;
    @Column(name = "address")
    private String address;
    @Column(name = "status")
    private Integer status;
    @Column(name = "createddate")
    private Date createddate;
    @Column(name = "usercode")
    private String usercode;
    @Column(name = "islocked")
    private Boolean islocked;
    @Column(name = "isdeleted")
    private Boolean isdeleted;
    @Column(name = "unitid", columnDefinition = "uniqueidentifier")
    private UUID unitid;
    @Column(name = "isactive")
    private Boolean isactive;
    @Column(name = "createdby", columnDefinition = "uniqueidentifier")
    private UUID createdby;
    @Column(name = "activecode")
    private String activecode;
    @Column(name = "avatar")
    private String avatar;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
