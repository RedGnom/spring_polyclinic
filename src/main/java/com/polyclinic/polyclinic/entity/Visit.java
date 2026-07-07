package com.polyclinic.polyclinic.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "visits")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "visit_time", nullable = false)
    private LocalDateTime visitTime; // Время приема

    @Column(name = "duration")
    private Duration duration; // Длительность приема

    // Связь с пациентом, кто проходил прием
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "patient_profile_id", nullable = false)
    private PatientProfile patient;

    // Связь с врачом, кто проводил прием
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_profile_id", nullable = false)
    private DoctorProfile doctorProfile;








}
