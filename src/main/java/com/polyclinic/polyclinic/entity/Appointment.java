package com.polyclinic.polyclinic.entity;


import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import com.polyclinic.polyclinic.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_profile_id")
    private PatientProfile patientProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_profile_id")
    private DoctorProfile doctorProfile;

    private LocalDateTime scheduledTime; // Время записи пациента

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status; // Статус записи

    // Связанный визит
    @OneToOne(mappedBy = "appointment",cascade = CascadeType.ALL)
    private Visit visit;
}
