package com.polyclinic.polyclinic.entity;

import com.polyclinic.polyclinic.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "password", unique = true, nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "secondName_name", nullable = false)
    private String secondName;

    @Column(name = "patronymic")
    private String patronymic;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    // Профиль пациента для пользователя(диагнозы и пр)
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private DoctorProfile doctorProfile;

    // Профиль врача
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private PatientProfile patientProfile;
}
