package com.example.project.BackendSpring.Services.Implement;

import com.example.project.BackendSpring.Utilities.ListRoleOfUser;
import com.example.project.BackendSpring.Models.UserRole;
import com.example.project.BackendSpring.Repositories.UserRoleRepository;
import com.example.project.BackendSpring.Services.Interfaces.UserRoleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserRoleService implements UserRoleInterface {
    @Autowired
    UserRoleRepository userRoleRepository;
    @Override
    public List<UserRole> listUserRole(UUID idUser) {
        return userRoleRepository.getAllRoleOfUser(idUser);
    }

    @Override
    public List<ListRoleOfUser> GetAllInfoRoleOfUser(UUID idUUser) {
        var datas = userRoleRepository.getAllInformRoleOfUser(idUUser);
        List<ListRoleOfUser> roleObjects = datas.stream()
                .map(obj -> (Object[]) obj) // cast the object to an array of objects
                .map(arr -> new ListRoleOfUser((String) arr[0], (String)arr[1], (String) arr[2], (Integer) arr[3])) // map the array to a Role object
                .collect(Collectors.toList()); // collect the stream into a list
        return roleObjects;
    }
}
