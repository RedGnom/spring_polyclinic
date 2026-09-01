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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;


    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с id " + id + " не найден"));
    }

    @Transactional
    public User createUser(RegisterDto registerDto){
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new IllegalStateException("Пользователя с почтой " + registerDto.getEmail() + " уже существует");
        }

        User user = mapper.toUserEntity(registerDto);

        // Шифрование пароля
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Изначально пустая роль пользователя
        user.getRoles().add(Role.USER);

        userRepository.save(user);

        return user;
    }
    // Получение dto с общими данными о пользователе
    public UserDto getUserDto(Long userId){
        User user = getUserById(userId);

        // mapper для полей dto
        return mapper.toUserDto(user);
    }

}
