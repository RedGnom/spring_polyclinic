package com.polyclinic.polyclinic.repository;

import com.polyclinic.polyclinic.entity.Diagnose;
import com.polyclinic.polyclinic.entity.PatientProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiagnoseRepository extends JpaRepository<Diagnose, Long> {
    Optional<Diagnose> findByDiagnosisName(String diagnosisName);
    Optional<Diagnose> findById(Long id);
}
