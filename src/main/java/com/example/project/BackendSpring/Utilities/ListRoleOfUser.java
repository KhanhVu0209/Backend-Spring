package com.example.project.BackendSpring.Utilities;

public class ListRoleOfUser {
    private String IdRole;
    private String NameRole;
    private String IdUser;
    private Integer IsAdmin;

    public ListRoleOfUser(String idRole, String nameRole, String idUser, Integer isAdmin) {
        IdRole = idRole;
        NameRole = nameRole;
        IdUser = idUser;
        IsAdmin = isAdmin;
    }

    public String getIdRole() {
        return IdRole;
    }

    public void setIdRole(String idRole) {
        IdRole = idRole;
    }

    public String getNameRole() {
        return NameRole;
    }

    public void setNameRole(String nameRole) {
        NameRole = nameRole;
    }

    public String getIdUser() {
        return IdUser;
    }

    public void setIdUser(String idUser) {
        IdUser = idUser;
    }

    public Integer getIsAdmin() {
        return IsAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        IsAdmin = isAdmin;
    }
}
