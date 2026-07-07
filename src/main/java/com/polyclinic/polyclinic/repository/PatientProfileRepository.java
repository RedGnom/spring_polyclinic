package com.polyclinic.polyclinic.repository;

import com.polyclinic.polyclinic.entity.PatientProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientProfileRepository extends JpaRepository<PatientProfile, Long> {
    @Query("SELECT p FROM PatientProfile p JOIN p.diagnoses d WHERE d.id = :diagnoseId")
    List<PatientProfile> findByDiagnoseId(@Param("diagnoseId") Long diagnoseId);
}
