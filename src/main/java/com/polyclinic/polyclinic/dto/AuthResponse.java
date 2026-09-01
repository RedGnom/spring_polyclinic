package com.polyclinic.polyclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Getter
public class AuthResponse {
    private String token;
    private UserDto userProfile;
}
