package com.polyclinic.polyclinic.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {
    private Long id;
    private String email;

    private LocalDate birthDate;

    private String firstName;

    private String secondName;

    private String patronymic;

}
