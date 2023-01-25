package com.example.project.BackendSpring.Controllers;

import com.example.project.BackendSpring.Dtos.UserDto;
import com.example.project.BackendSpring.Models.User;
import com.example.project.BackendSpring.Services.Implement.*;
import com.example.project.BackendSpring.Utilities.JwtService;
import com.example.project.BackendSpring.Utilities.TemplateApi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserTypeService userTypeService;
    @Autowired
    UnitService unitService;
    @Value("${app.serverFileAvartar}")
    private String serverFileAvartar;
    @Value("${app.secretKey}")
    private String secretKey;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    //CRUD TABLE USER
    @GetMapping("/getAllUserAvailable")
    public ResponseEntity<TemplateApi> getAllUserAvailable(int pageNumber, int pageSize) {
        var result = userService.GetAllUserAvailable(pageNumber, pageSize);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<TemplateApi> getAllUser(int pageNumber, int pageSize) {
        var result = userService.GetAllUser(pageNumber, pageSize);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<TemplateApi> getUserById(@PathVariable("id") String idUser) {
        var result = userService.GetUserById(UUID.fromString(idUser));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUsers")
    public ResponseEntity<TemplateApi> deleteUsers(@RequestBody List<UUID> idUsers) {
        UUID idUserCurrent = UUID.randomUUID();
        String fullName = "";
        var result = userService.DeleteUsers(idUsers, idUserCurrent, fullName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/lockUsers")
    public ResponseEntity<TemplateApi> lockUsers(@RequestBody List<UUID> idUsers) {
        UUID idUserCurrent = UUID.randomUUID();
        String fullName = "";
        var result = userService.LockUsers(idUsers, idUserCurrent, fullName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/insertUser")
    public ResponseEntity<TemplateApi> insertUser(
            @RequestHeader("Authorization") String token,
            @RequestParam("fullname") String fullname,
            @RequestParam("password") String password,
            @RequestParam("email") String email,
            @RequestParam("usertypeid") UUID usertypeid,
            @RequestParam("description") String description,
            @RequestParam("phone") String phone,
            @RequestParam("address") String address,
            @RequestParam("unitId") UUID unitId,
            @RequestParam("file") MultipartFile file) throws IOException {
        var claimData = jwtService.extractAllClaims(token.substring(7));

        User user = userService.GetUserByEmail(email);
        if (user != null) {
            return new ResponseEntity<>(new TemplateApi() {{
                setMessage("Email đã tồn tại !");
                setFail(true);
                setSuccess(false);
            }}, HttpStatus.OK);
        }
        UserDto userDto = new UserDto();
        userDto.setId(UUID.randomUUID());
        userDto.setFullname(fullname);
        userDto.setEmail(email);
        userDto.setPassword(passwordEncoder.encode(password + secretKey));
        userDto.setCreateddate(new Date());
        userDto.setIsdeleted(false);
        userDto.setIslocked(false);
        userDto.setIsactive(false);
        userDto.setActivecode(String.valueOf(Instant.now().getEpochSecond()));
        userDto.setUsercode(String.valueOf(Instant.now().toEpochMilli()));
        userDto.setUsertypeid(usertypeid);
        userDto.setUnitid(unitId);
        userDto.setAddress(address);
        userDto.setPhone(phone);
        userDto.setStatus(0);
        userDto.setCreatedby(UUID.fromString(claimData.get("id").toString()));
        userDto.setDescription(description);
        userDto.setAvatar(userDto.getId() + ".jpg");

        File theDir = new File(serverFileAvartar);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        byte[] bytes = file.getBytes();
        Path path = Paths.get(serverFileAvartar + "/" + userDto.getId() + ".jpg");
        Files.write(path, bytes);

        var result = userService.InsertUser(userDto, UUID.fromString(claimData.get("id").toString()), claimData.get("username").toString());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("updateUser")
    public ResponseEntity<TemplateApi> updateUser(@RequestHeader("Authorization") String token,
                                                  @RequestParam("id") UUID id,
                                                  @RequestParam("fullname") String fullname,
                                                  @RequestParam("usertypeid") UUID usertypeid,
                                                  @RequestParam("description") String description,
                                                  @RequestParam("phone") String phone,
                                                  @RequestParam("address") String address,
                                                  @RequestParam("unitId") UUID unitId,
                                                  @RequestParam("file") MultipartFile file) throws IOException{
        var claimData = jwtService.extractAllClaims(token.substring(7));

        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setFullname(fullname);
        userDto.setUsertypeid(usertypeid);
        userDto.setUnitid(unitId);
        userDto.setAddress(address);
        userDto.setPhone(phone);
        userDto.setDescription(description);

        File theDir = new File(serverFileAvartar);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        byte[] bytes = file.getBytes();
        Path path = Paths.get(serverFileAvartar + "/" + userDto.getId() + ".jpg");
        Files.write(path, bytes);

        var result = userService.UpdateUser(userDto, UUID.fromString(claimData.get("id").toString()), claimData.get("username").toString());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping("addRoleUser")
    public ResponseEntity<TemplateApi> addRoleUser(@RequestParam UUID idRole, @RequestParam UUID idUser,@RequestHeader("Authorization") String token){
        var claimData = jwtService.extractAllClaims(token.substring(7));
        var result = userService.AddUserRole(idRole, idUser,UUID.fromString(claimData.get("id").toString()), claimData.get("username").toString());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
