package com.polyclinic.polyclinic.controller;

import com.polyclinic.polyclinic.dto.AuthResponse;
import com.polyclinic.polyclinic.dto.LoginDto;
import com.polyclinic.polyclinic.dto.RegisterDto;
import com.polyclinic.polyclinic.dto.UserDto;
import com.polyclinic.polyclinic.service.AuthService;
import com.polyclinic.polyclinic.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    @GetMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody
                                        LoginDto loginDto){
        String token = authService.login(loginDto);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/registration")
    public ResponseEntity<AuthResponse> registerUser(@Valid @RequestBody
                                                RegisterDto registerDto){
        AuthResponse authResponse = authService.register(registerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(authResponse);
    }


}
