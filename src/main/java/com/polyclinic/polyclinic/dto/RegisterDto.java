package com.polyclinic.polyclinic.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterDto {
    @Email
    @NotBlank(message = "Почта не может быть пустой")
    private String email;

    @NotBlank(message = "Пароль не может быть пустым")
    @Size(min = 6, message = "Длина пароля от 6 символов")
    private String password;

    @NotNull
    private LocalDate birthDate;

    @NotBlank(message = "Имя не может быть пустым")
    private String firstName;

    @NotBlank(message = "Фамилия не может быть пустой")
    private String secondName;

    private String patronymic;
}
