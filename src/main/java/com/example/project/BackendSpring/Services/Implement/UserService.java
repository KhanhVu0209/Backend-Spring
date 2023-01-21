package com.example.project.BackendSpring.Services.Implement;

import com.example.project.BackendSpring.Dtos.UserDto;
import com.example.project.BackendSpring.Models.*;
import com.example.project.BackendSpring.Repositories.*;
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
    @Autowired
    UnitRepository unitRepository;
    @Autowired
    UserTypeRepository userTypeRepository;

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
    public TemplateApi InsertUser(UserDto userDto, UUID idUserCurrent, String fullName) {
        List<Diary> diaries = new ArrayList<>();
        var saveToDiary = new SaveToDiary();

        var user = new User();
        BeanUtils.copyProperties(userDto, user);

        userRepository.save(user);
        logger.info("Thêm mới thành công người dùng");
        diaries.add(saveToDiary.InsertDiary("Create", idUserCurrent, user.getId(), fullName, "User", ""));

        if (userDto.getIdrole() != null) {
            var userRole = new UserRole();
            userRole.setId(UUID.randomUUID());
            userRole.setIdrole(userDto.getIdrole());
            userRole.setIduser(user.getId());

            userRoleRepository.save(userRole);
            logger.info("Thêm mới thành công role người dùng");
            diaries.add(saveToDiary.InsertDiary("Create", idUserCurrent, userRole.getId(), fullName, "UserRole", ""));
        }

        diaryRepository.saveAll(diaries);
        return new TemplateApi("Thêm mới thành công !", true, false);
    }

    @Override
    public TemplateApi GetAllUser(int pageNumber, int pageSize) {
        var users = userRepository.getAllUser();

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
    public TemplateApi GetAllUserAvailable(int pageNumber, int pageSize) {
        var users = userRepository.getAllUserAvailable();

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
        if (user == null) return new TemplateApi("Không tìm thấy người dùng !", false, true);
        return new TemplateApi(user, null, "Lấy thông tin người dùng thành công !", true, false, 0, 0, 1, 0);
    }

    @Override
    public TemplateApi DeleteUsers(List<UUID> idUsers, UUID idUserCurrent, String fullName) {
        List<Diary> diaries = new ArrayList<>();
        var saveToDiary = new SaveToDiary();

        var checkIdsValid = userRepository.getIdUsersByListId(idUsers);
        if (checkIdsValid.size() != idUsers.size()) return new TemplateApi("Đã có ID không tồn tại !", false, true);

        for (int i = 0; i < idUsers.size(); i++) {
            User userById = userRepository.findById(idUsers.get(i)).orElse(null);

            userById.setIsdeleted(true);
            userById.setEmail(userById.getEmail() + "/" + userById.getId());
            userRepository.save(userById);

            diaries.add(saveToDiary.InsertDiary("Delete", idUserCurrent, userById.getId(), fullName, "User", ""));
        }
        diaryRepository.saveAll(diaries);

        logger.info("Xóa thành công người dùng");
        return new TemplateApi("Xóa thành công !", true, false);
    }

    @Override
    public TemplateApi LockUsers(List<UUID> idUsers, UUID idUserCurrent, String fullName) {
        List<Diary> diaries = new ArrayList<>();
        var saveToDiary = new SaveToDiary();

        var checkIdsValid = userRepository.getIdUsersByListId(idUsers);
        if (checkIdsValid.size() != idUsers.size()) return new TemplateApi("Đã có ID không tồn tại !", false, true);

        for (int i = 0; i < idUsers.size(); i++) {
            User userById = userRepository.findById(idUsers.get(i)).orElse(null);

            userById.setIslocked(true);
            userRepository.save(userById);

            diaries.add(saveToDiary.InsertDiary("Update", idUserCurrent, userById.getId(), fullName, "User", ""));
        }
        diaryRepository.saveAll(diaries);

        logger.info("Khóa thành công người dùng");
        return new TemplateApi("Khóa tài khoản thành công !", true, false);
    }

    @Override
    public TemplateApi ActiveUserByCode(String email, Boolean code, UUID idUserCurrent, String fullName) {
        List<Diary> diaries = new ArrayList<>();
        var saveToDiary = new SaveToDiary();

        var user = userRepository.findByEmail(email);
        user.setIsactive(true);
        userRepository.save(user);

        diaries.add(saveToDiary.InsertDiary("Update", idUserCurrent, user.getId(), fullName, "User", "Kích hoạt người dùng"));
        diaryRepository.saveAll(diaries);

        logger.info("Kích hoạt thành công người dùng");
        return new TemplateApi("Tài khoản của bạn đã được kích hoạt !", true, false);
    }

    @Override
    public TemplateApi UpdatePassword(String email, String newPassWord, UUID idUserCurrent, String fullName) {
        List<Diary> diaries = new ArrayList<>();
        var saveToDiary = new SaveToDiary();

        var user = userRepository.findByEmail(email);
        user.setPassword(newPassWord);
        userRepository.save(user);

        diaries.add(saveToDiary.InsertDiary("Update", idUserCurrent, user.getId(), fullName, "User", "Cập nhật mật khẩu người dùng"));
        diaryRepository.saveAll(diaries);

        logger.info("Cập nhật mật khẩu người dùng");
        return new TemplateApi("Cập nhật mật khẩu thành công !", true, false);
    }

    @Override
    public User GetUserByEmail(String Email) {
        return userRepository.findByEmail(Email);
    }

    @Override
    public Optional<User> GetUserByEmailOp(String email) {
        return userRepository.findUserByEmail(email);
    }
}
