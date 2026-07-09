package com.polyclinic.polyclinic.service;

import com.polyclinic.polyclinic.dto.UserDto;
import com.polyclinic.polyclinic.entity.User;
import com.polyclinic.polyclinic.mapper.UserMapper;
import com.polyclinic.polyclinic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;


    // Возврат пользователя с проверкой на наличие
    public User getUserProfile(String email){
         return userRepository.findByEmail(email)
                 .orElseThrow(() -> new UsernameNotFoundException("Пользователя с почтой " + email + " не найден"));

    }
    // Получение dto с общими данными о пользователе
    public UserDto getPatientBaseInfo(String email){
        User user = getUserProfile(email);

        // mapper для полей dto 
        return mapper.toUserDto(user);
    }

}
