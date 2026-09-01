package com.polyclinic.polyclinic.service;

import com.polyclinic.polyclinic.dto.AuthResponse;
import com.polyclinic.polyclinic.dto.LoginDto;
import com.polyclinic.polyclinic.dto.RegisterDto;
import com.polyclinic.polyclinic.dto.UserDto;
import com.polyclinic.polyclinic.entity.User;
import com.polyclinic.polyclinic.mapper.UserMapper;
import com.polyclinic.polyclinic.security.CustomUserDetails;
import com.polyclinic.polyclinic.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final UserService userService;
    private final UserMapper userMapper;

    public String login(LoginDto loginDto){
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        String token = jwtService.generateToken(userDetails);

        return token;
    }

    public AuthResponse register(RegisterDto registerDto){
        User user = userService.createUser(registerDto);

        CustomUserDetails userDetails = CustomUserDetails.fromEntityUser(user);

        String token = jwtService.generateToken(userDetails);

        UserDto userDto = userMapper.toUserDto(user);

        return new AuthResponse(token, userDto);
    }

}
