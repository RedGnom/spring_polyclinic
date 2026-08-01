package com.polyclinic.polyclinic.service;

import com.polyclinic.polyclinic.dto.RegisterDto;
import com.polyclinic.polyclinic.dto.UserDto;
import com.polyclinic.polyclinic.entity.User;
import com.polyclinic.polyclinic.enums.Role;
import com.polyclinic.polyclinic.mapper.UserMapper;
import com.polyclinic.polyclinic.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;


    // Возврат пользователя с проверкой на наличие
    public User getUserByEmail(String email){
         return userRepository.findByEmail(email)
                 .orElseThrow(() -> new UsernameNotFoundException("Пользователя с почтой " + email + " не найден"));
    }

    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с id " + id + " не найден"));
    }

    @Transactional
    public UserDto createUser(RegisterDto registerDto){
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new IllegalStateException("Пользователя с почтой " + registerDto.getEmail() + " уже существует");
        }
        User user = new User();

        user = mapper.toUserEntity(registerDto);
        // Изначально пустая роль пользователя
        user.setRole(Role.USER);

        userRepository.save(user);

        return mapper.toUserDto(user);


    }
    // Получение dto с общими данными о пользователе
    public UserDto getUserDto(Long userId){
        User user = getUserById(userId);

        // mapper для полей dto 
        return mapper.toUserDto(user);
    }

}
