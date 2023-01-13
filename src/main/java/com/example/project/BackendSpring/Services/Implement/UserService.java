package com.example.project.BackendSpring.Services.Implement;

import com.example.project.BackendSpring.Dtos.UserDto;
import com.example.project.BackendSpring.Models.*;
import com.example.project.BackendSpring.Repositories.DiaryRepository;
import com.example.project.BackendSpring.Repositories.RoleRepository;
import com.example.project.BackendSpring.Repositories.UserRepository;
import com.example.project.BackendSpring.Repositories.UserRoleRepository;
import com.example.project.BackendSpring.Services.Interfaces.UserInterface;
import com.example.project.BackendSpring.Utilities.SaveToDiary;
import com.example.project.BackendSpring.Utilities.TemplateApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserInterface {
    @Autowired
    DiaryRepository diaryRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRoleRepository userRoleRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Override
    public TemplateApi UpdateUser(UserDto UserDto, UUID idUserCurrent, String fullName) {
        List<Diary> diaries = new ArrayList<>();
        var saveToDiary = new SaveToDiary();

        User user = new User();
        user = userRepository.findById(UserDto.getId()).orElse(null);
        if (user == null) return new TemplateApi("Không tìm thấy người dùng !", false, true);

        BeanUtils.copyProperties(UserDto, user);
        userRepository.save(user);
        logger.info("Cập nhật thành công người dùng");

        return new TemplateApi("Cập nhật thành công !", true, false);
    }

    @Override
    public TemplateApi InsertUser(UserDto UserDto, UUID idUserCurrent, String fullName) {
        List<Diary> diaries = new ArrayList<>();
        var saveToDiary = new SaveToDiary();

        User user = new User();
        BeanUtils.copyProperties(UserDto, user);

        UserRole userRole = new UserRole();
        userRole.setId(UUID.randomUUID());
        userRole.setIdRole(UserDto.getIdRole());
        userRole.setIdUser(user.getId());

        userRoleRepository.save(userRole);
        logger.info("Thêm mới thành công role người dùng");

        userRepository.save(user);
        logger.info("Thêm mới thành công người dùng");

        return new TemplateApi("Thêm mới thành công !", true, false);
    }

    @Override
    public TemplateApi GetAllUser(int pageNumber, int pageSize) {
        var users = userRepository.findAll();

        if (pageNumber != 0 && pageSize != 0) {
            if (pageNumber < 0) {
                pageNumber = 1;
            }
            users = users.subList((pageNumber - 1) * pageSize, pageSize);
        }

        int NumPageSize = pageSize == 0 ? 1 : pageSize;
        logger.info("Lấy danh sách thành công !");
        return new TemplateApi(null, users.toArray(new User[0]), "Lấy danh sách thành công", true, false, pageNumber, pageSize, users.size(), NumPageSize);
    }

    @Override
    public TemplateApi GetUserById(UUID IdUser) {
        var user = userRepository.findById(IdUser).orElse(null);
        if (user == null) return new TemplateApi("Không tìm thấy người dùng", false, true);
        return new TemplateApi(user, null, "Lấy thông tin người dùng thành công", true, false, 0, 0, 1, 0);
    }

    @Override
    public TemplateApi DeleteUser(UUID IdUser, UUID idUserCurrent, String fullName) {
        List<Diary> diaries = new ArrayList<>();
        var saveToDiary = new SaveToDiary();

        User userById = userRepository.findById(IdUser).orElse(null);
        if (userById == null) return new TemplateApi("Không tìm thấy người dùng", false, true);

        userById.setDeleted(true);
        userById.setEmail(userById.getEmail() + "/" + userById.getId());
        userRepository.save(userById);

        diaries.add(saveToDiary.InsertDiary("Delete", idUserCurrent, userById.getId(), fullName, "User", ""));

        diaryRepository.saveAll(diaries);

        logger.info("Xóa thành công người dùng");
        return new TemplateApi("Xóa thành công !", true, false);
    }

    @Override
    public User GetUserByEmail(String Email) {
        return userRepository.findByEmail(Email);
    }
}
