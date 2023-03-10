package com.example.project.BackendSpring.auth;

import com.example.project.BackendSpring.Payload.UserPayloads.GetUserResponse;
import com.example.project.BackendSpring.Utilities.JwtService;
import com.example.project.BackendSpring.Dtos.UserDto;
import com.example.project.BackendSpring.Models.User;
import com.example.project.BackendSpring.Payload.UserPayloads.LoginUserRequest;
import com.example.project.BackendSpring.Payload.UserPayloads.RegisterUserRequest;
import com.example.project.BackendSpring.Payload.UserPayloads.UserLoginResponse;
import com.example.project.BackendSpring.Services.Implement.*;
import com.example.project.BackendSpring.Utilities.ListRoleOfUser;
import com.example.project.BackendSpring.Utilities.TemplateApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    UserTypeService userTypeService;
    @Autowired
    UnitService unitService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    @Value("${app.secretKey}")
    private String secretKey;
    @Value("${app.userTypeDefault}")
    private String userTypeDefault;
    @Value("${app.unitDefault}")
    private String unitDefault;
    private final UserDetailsService userDetailsService;


    @PostMapping("/register")
    public ResponseEntity<TemplateApi> register(@RequestBody RegisterUserRequest request) {
        User user = userService.GetUserByEmail(request.getEmail());
        if (user != null) {
            return new ResponseEntity<>(new TemplateApi() {{
                setSuccess(false);
                setFail(true);
                setMessage("T??i kho???n n??y ???? t???n t???i !");
            }}, HttpStatus.OK);
        }

        var unitData = unitService.GetUnitByUnitCode(unitDefault);
        var userTypeData = userTypeService.GetUserTypeByCode(userTypeDefault);
        var roleData = roleService.roleByRoleCode("US");
        if (unitData == null || userTypeData == null || roleData == null) {
            return new ResponseEntity<>(new TemplateApi() {{
                setSuccess(false);
                setFail(true);
                setMessage("????ng k?? kh??ng th??nh c??ng !");
            }}, HttpStatus.OK);
        }

        UserDto userDto = new UserDto();
        userDto.setId(UUID.randomUUID());
        userDto.setFullname(request != null ? request.getFullName() : null);
        userDto.setEmail(request != null ? request.getEmail() : "");
        userDto.setPassword(request != null ? passwordEncoder.encode(request.getPassword() + secretKey) : "");
        userDto.setCreateddate(new Date());
        userDto.setIsdeleted(false);
        userDto.setIslocked(false);
        userDto.setIsactive(false);
        userDto.setActivecode(String.valueOf(Instant.now().getEpochSecond()));
        userDto.setUsercode(String.valueOf(Instant.now().toEpochMilli()));
        userDto.setUsertypeid(userTypeData.getId());
        userDto.setUnitid(unitData.getId());
        userDto.setAddress(request != null ? request.getAddress() : null);
        userDto.setPhone(request != null ? request.getPhone() : null);
        userDto.setStatus(0);
        userDto.setCreatedby(userDto.getId());
        userDto.setIdrole(roleData.getId());

        userService.InsertUser(userDto, userDto.getId(), userDto.getFullname());
        return new ResponseEntity<>(new TemplateApi() {{
            setSuccess(true);
            setFail(false);
            setMessage("????ng k?? th??nh c??ng. H??y ki???m tra h???p th?? c???a b???n v?? x??c nh???n m?? !");
        }}, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody LoginUserRequest loginUserRequest) {
        User user = userService.GetUserByEmail(loginUserRequest.getEmail());
        if (user == null) {
            return new ResponseEntity<>(new UserLoginResponse(null, false, true, "T??i kho???n kh??ng t???n t???i !", null, null, null), HttpStatus.OK);
        }
        if (user.getIslocked()) {
            return new ResponseEntity<>(new UserLoginResponse(null, false, true, "T??i kho???n n??y ???? b??? kh??a !", null, null, null), HttpStatus.OK);
        }
        if (!user.getIsactive()) {
            return new ResponseEntity<>(new UserLoginResponse(null, false, true, "T??i kho???n n??y ch??a ???????c kich ho???t !", null, null, null), HttpStatus.OK);
        }
        if (!passwordEncoder.matches(loginUserRequest.getPassword() + secretKey, user.getPassword())) {
            return new ResponseEntity<>(new UserLoginResponse(null, false, true, "M???t kh???u kh??ng ch??nh x??c !", null, null, null), HttpStatus.OK);
        }

        var dataRoleUsers = userRoleService.GetAllInfoRoleOfUser(user.getId());

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("email", user.getEmail());
        extraClaims.put("username", user.getFullname());
        extraClaims.put("id", user.getId());
        extraClaims.put("role", "user");

        Boolean isAdmin = dataRoleUsers.stream()
                .filter(role -> role.getIsAdmin() == 1)
                .findFirst()
                .map(role -> {
                    extraClaims.put("role", "admin");
                    return true;
                })
                .orElse(false);

        var jwtToken = jwtService.generateToken(extraClaims, user);
        return new ResponseEntity<>(new UserLoginResponse() {{
            setFail(false);
            setSuccess(true);
            setMessage("????ng nh???p th??nh c??ng !");
            setId(user.getId());
            setData(new HashMap<String, String>() {{
                put("AccessToken", jwtToken);
            }});
            setRoleList(dataRoleUsers.toArray(new ListRoleOfUser[0]));
            setAdmin(isAdmin);
        }}, HttpStatus.OK);
    }

    @GetMapping("/getUser")
    public ResponseEntity<GetUserResponse> getUser(@RequestHeader(value = "Authorization", required = false) String token) {

        if (token == null) {
            return new ResponseEntity<>(new GetUserResponse(false, "Kh??ng t??m th???y token !"), HttpStatus.OK);
        }

        String userEmail = jwtService.extractUsername(token.substring(7));
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
        if (jwtService.isTokenValid(token.substring(7), userDetails)) {
            var claimData = jwtService.extractAllClaims(token.substring(7));

            User user = userService.GetUserByEmail(claimData.get("email").toString());
            var dataRoleUsers = userRoleService.GetAllInfoRoleOfUser(user.getId());
            Boolean checkIsAdmin = dataRoleUsers.stream()
                    .filter(role -> role.getIsAdmin() == 1)
                    .findFirst()
                    .map(role -> {
                        return true;
                    })
                    .orElse(false);

            var userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
            return new ResponseEntity<>(new GetUserResponse(userDto, dataRoleUsers.toArray(new ListRoleOfUser[0]), true, "L???y th??ng tin ng?????i d??ng th??nh c??ng !", checkIsAdmin), HttpStatus.OK);
        }
        return new ResponseEntity<>(new GetUserResponse(false, "Token kh??ng h???p l??? !"), HttpStatus.OK);
    }

    @PutMapping("/activeUserByCode")
    public ResponseEntity<TemplateApi> activeUserByCode(String email, Boolean code) {
        User user = userService.GetUserByEmail(email);
        if (user == null) {
            return new ResponseEntity<>(new TemplateApi() {{
                setMessage("T??i kho???n n??y ch??a t???n t???i !");
                setFail(true);
                setSuccess(false);
            }}, HttpStatus.OK);
        }
        if (user.getIsactive()) {
            return new ResponseEntity<>(new TemplateApi() {{
                setMessage("T??i kho???n n??y ???? ???????c k??ch ho???t !");
                setFail(true);
                setSuccess(false);
            }}, HttpStatus.OK);
        }
        if (user.getIsactive() != code) {
            return new ResponseEntity<>(new TemplateApi() {{
                setMessage("Vui l??ng nh???p ????ng m?? code !");
                setFail(true);
                setSuccess(false);
            }}, HttpStatus.OK);
        }

        var result = userService.ActiveUserByCode(email, code);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/verifyCode")
    public ResponseEntity<TemplateApi> verifyCode(String email, String code) {
        User user = userService.GetUserByEmail(email);
        if (user == null) {
            return new ResponseEntity<>(new TemplateApi() {{
                setMessage("T??i kho???n n??y ch??a t???n t???i !");
                setFail(true);
                setSuccess(false);
            }}, HttpStatus.OK);
        }
        if (user.getIsactive() && user.getActivecode() == code) {
            return new ResponseEntity<>(new TemplateApi() {{
                setMessage("X??c th???c th??nh c??ng !");
                setFail(false);
                setSuccess(true);
            }}, HttpStatus.OK);
        }
        return new ResponseEntity<>(new TemplateApi() {{
            setMessage("Vui l??ng nh???p ch??nh x??c th??ng tin !");
            setFail(true);
            setSuccess(false);
        }}, HttpStatus.OK);
    }

    @PutMapping("/forgotPassWord")
    public ResponseEntity<TemplateApi> forgotPassWord(String email, String newPassWord) {
        User user = userService.GetUserByEmail(email);
        if (user == null) {
            return new ResponseEntity<>(new TemplateApi() {{
                setMessage("T??i kho???n n??y ch??a t???n t???i !");
                setFail(true);
                setSuccess(false);
            }}, HttpStatus.OK);
        }
        if (!user.getIsactive()) {
            return new ResponseEntity<>(new TemplateApi() {{
                setMessage("T??i kho???n n??y ch??a ???????c kich ho???t !");
                setFail(true);
                setSuccess(false);
            }}, HttpStatus.OK);
        }

        var result = userService.UpdatePassword(email, passwordEncoder.encode(newPassWord));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/changePassWord")
    public ResponseEntity<TemplateApi> changePassWord(String email, String oldPassWord, String newPassWord) {
        User user = userService.GetUserByEmail(email);
        if (user == null) {
            return new ResponseEntity<>(new TemplateApi() {{
                setMessage("T??i kho???n n??y ch??a t???n t???i !");
                setFail(true);
                setSuccess(false);
            }}, HttpStatus.OK);
        }
        if (!user.getIsactive()) {
            return new ResponseEntity<>(new TemplateApi() {{
                setMessage("T??i kho???n n??y ch??a ???????c kich ho???t !");
                setFail(true);
                setSuccess(false);
            }}, HttpStatus.OK);
        }
        if (!passwordEncoder.matches(oldPassWord, user.getPassword())) {
            return new ResponseEntity<>(new TemplateApi() {{
                setMessage("M???t kh???u c?? kh??ng ch??nh x??c !");
                setFail(true);
                setSuccess(false);
            }}, HttpStatus.OK);
        }

        var result = userService.UpdatePassword(email, passwordEncoder.encode(newPassWord));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
