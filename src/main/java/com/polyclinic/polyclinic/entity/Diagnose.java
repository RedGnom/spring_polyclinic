package com.polyclinic.polyclinic.entity;

import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "diagnoses")
public class Diagnose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Название диагноза
    @Column(name = "diagnosis_name", unique = true, nullable = false)
    private String diagnosisName;

    // Обратная связь с пациентом
    @ManyToMany(mappedBy = "diagnoses")
    private List<PatientProfile> patients;
}
