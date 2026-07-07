package com.polyclinic.polyclinic.repository;

import com.polyclinic.polyclinic.entity.Diagnose;
import com.polyclinic.polyclinic.entity.PatientProfile;

import java.util.Optional;

public interface DiagnoseRepository {
    Optional<Diagnose> findByDiagnosisName(String diagnosisName);
}
