package com.polyclinic.polyclinic.security;

import com.polyclinic.polyclinic.entity.User;
import com.polyclinic.polyclinic.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователя с почтой " + username + " не найден"));
        // Конвертация entity user в user details
        return CustomUserDetails.fromEntityUser(user);
    }

}
