package com.polyclinic.polyclinic.controller;

import com.polyclinic.polyclinic.dto.RegisterDto;
import com.polyclinic.polyclinic.dto.UserDto;
import com.polyclinic.polyclinic.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {
    final private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<?> registerUser(@Valid @RequestBody
                                                RegisterDto registerDto){
        UserDto userDto = userService.createUser(registerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }




}
