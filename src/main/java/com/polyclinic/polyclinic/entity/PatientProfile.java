package com.polyclinic.polyclinic.entity;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "patient_profile")
public class PatientProfile {
    @Id
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String height;

    @Column(nullable = false)
    private String weight;

    // Связь многие ко многим диагноза и пациента
    @ManyToMany
    @JoinTable(
            name = "patient_diagnoses",
            joinColumns = @JoinColumn(name = "patient_profile_id"),
            inverseJoinColumns = @JoinColumn(name = "diagnose_id")
    )
    private List<Diagnose> diagnoses = new ArrayList<>();

}
