package com.polyclinic.polyclinic.security;

import com.polyclinic.polyclinic.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Getter
public class CustomUserDetails implements UserDetails {
    private final Long id;
    private final String email;
    private final Collection<? extends GrantedAuthority> authorities;

    @Override
    public String getUsername(){
        return email;
    }

    @Override
    public String getPassword(){
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return authorities;
    }

    @Override public boolean isAccountNonExpired()     { return true; }
    @Override public boolean isAccountNonLocked()      { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled()               { return true; }

    // Details из сущности
    public static CustomUserDetails fromEntityUser(User user) {

        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                .collect(Collectors.toSet());


        return new CustomUserDetails(
                user.getId(),
                user.getEmail(),
                authorities
        );
    }

    // Details из JWT токена
    public static CustomUserDetails fromClaims(Map<String, Object> claims) {
        Collection<String> roles = (Collection<String>) claims.get("roles");

        Set<GrantedAuthority> auths = roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());

        return new CustomUserDetails(
                Long.valueOf(claims.get("id").toString()),
                (String) claims.get("email"),
                auths
        );
    }


}
