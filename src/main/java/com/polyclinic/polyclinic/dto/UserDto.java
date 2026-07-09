package com.polyclinic.polyclinic.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PatientDto {
    private String email;

    private LocalDate birthDate;

    private String firstName;

    private String secondName;

    private String patronymic;

}
