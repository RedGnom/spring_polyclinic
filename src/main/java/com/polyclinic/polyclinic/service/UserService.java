package com.polyclinic.polyclinic.service;

import com.polyclinic.polyclinic.dto.LoginDto;
import com.polyclinic.polyclinic.dto.PatientDto;
import com.polyclinic.polyclinic.entity.User;
import com.polyclinic.polyclinic.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository rep){
        this.userRepository = rep;
    }

    public User getUserProfile(String email){
         return userRepository.findByEmail(email)
                 .orElseThrow(() -> new UsernameNotFoundException("Пользователя с почтой " + email + " не найден"));

    }

}
