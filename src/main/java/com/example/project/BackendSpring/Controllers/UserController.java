package com.example.project.BackendSpring.Controllers;

import com.example.project.BackendSpring.Configs.JwtService;
import com.example.project.BackendSpring.Dtos.UserDto;
import com.example.project.BackendSpring.Models.User;
import com.example.project.BackendSpring.Models.UserRole;
import com.example.project.BackendSpring.Payload.UserPayloads.LoginUserRequest;
import com.example.project.BackendSpring.Payload.UserPayloads.TokenModel;
import com.example.project.BackendSpring.Payload.UserPayloads.UserLoginRespons;
import com.example.project.BackendSpring.Services.Implement.RoleService;
import com.example.project.BackendSpring.Services.Implement.UserRoleService;
import com.example.project.BackendSpring.Services.Implement.UserService;
import com.example.project.BackendSpring.Utilities.TemplateApi;
import com.example.project.BackendSpring.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<TemplateApi> register(@RequestBody RegisterRequest request) {
        UserDto userDto = new UserDto();
        userDto.setId(UUID.randomUUID());
        userDto.setFullname(request != null ? request.getFullName() : null);
        userDto.setEmail(request != null ? request.getEmail() : "");
        userDto.setPassword(request != null ? passwordEncoder.encode(request.getPassword()) : "");
        userDto.setCreatedDate(new Date());
        userDto.setDeleted(false);
        userDto.setLocked(false);
        userDto.setActive(false);
        userDto.setActiveCode(String.valueOf(Instant.now().getEpochSecond()));
        userDto.setUserCode(String.valueOf(Instant.now().toEpochMilli()));
        userDto.setUserTypeId(UUID.randomUUID());
        userDto.setUnitId(UUID.randomUUID());
        userDto.setAddress(request != null ? request.getAddress() : null);
        userDto.setPhone(request != null ? request.getPhone() : null);

        var role = roleService.roleByRoleCode("US");
        if (role == null) {
            return new ResponseEntity<>(new TemplateApi() {{
                setSuccess(false);
                setFail(true);
                setMessage("Đăng kí không thành công !");
            }}, HttpStatus.OK);
        }
        userDto.setIdRole(role.getId());

        userService.InsertUser(userDto, userDto.getId(), userDto.getFullname());
        return new ResponseEntity<>(new TemplateApi() {{
            setSuccess(true);
            setFail(false);
            setMessage("Đăng kí thành công. Hãy kiểm tra hộp thư của bạn và xác nhận mã !");
        }}, HttpStatus.OK);

    }
    @PostMapping("/login")
    public ResponseEntity<UserLoginRespons> login(@RequestBody LoginUserRequest loginUserRequest) {
        var check = CheckValidLogin(loginUserRequest);
        if (check.getFail()) return new ResponseEntity<>(check, HttpStatus.OK);
        return new ResponseEntity<>(new UserLoginRespons() {{
            setId(check.getId());
            setSuccess(check.getSuccess());
            setFail(check.getFail());
            setMessage(check.getMessage());
            setData(check.getData());
        }}, HttpStatus.OK);
    }
    private UserLoginRespons CheckValidLogin(LoginUserRequest loginUserRequest){
        User user = userService.GetUserByEmail(loginUserRequest.getEmail());
        if (user == null){
            return new UserLoginRespons(null,false,true,"Tài khoản không tồn tại !",null, null);
        }
        if (user.isLocked()){
            return new UserLoginRespons(null,false,true,"Tài khoản này đã bị khóa !",null, null);
        }
        if (!user.isActive()){
            return new UserLoginRespons(null,false,true,"Tài khoản này chưa được kich hoạt !",null, null);
        }
        if (passwordEncoder.matches(loginUserRequest.getPassword(), user.getPassword())){
            return new UserLoginRespons(null,false,true,"Mật khẩu không chính xác !",null, null);
        }
        var jwtToken = jwtService.generateToken(user);
        TokenModel tokenModel = new TokenModel(jwtToken, "");

        var dataRoleUser = userRoleService.GetAllInforRoleOfUser(user.getId());

        return new UserLoginRespons(user.getId(),false,true,"Đăng kí thành công. Hãy kiểm tra hộp thư của bạn và xác nhận mã !",tokenModel, dataRoleUser);
    }
}
