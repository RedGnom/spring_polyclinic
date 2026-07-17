package com.polyclinic.polyclinic.repository;

import com.polyclinic.polyclinic.entity.PatientProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientProfileRepository extends JpaRepository<PatientProfile, Long> {

    // Получаем диагнозы вместе с остальными данными
    @Query("SELECT DISTINCT p FROM PatientProfile p LEFT JOIN FETCH p.diagnoses WHERE p.userId = :userId")
    Optional<PatientProfile> findByIdWithDiagnoses(@Param("userId") Long userId);

    @Query("SELECT p FROM PatientProfile p JOIN p.diagnoses d WHERE d.id = :diagnoseId")
    List<PatientProfile> findByDiagnoseId(@Param("diagnoseId") Long diagnoseId);

    boolean existsByUserId(Long userId);
}
