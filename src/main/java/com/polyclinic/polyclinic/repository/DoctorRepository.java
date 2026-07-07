package com.polyclinic.polyclinic.repository;

import com.polyclinic.polyclinic.entity.DoctorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorProfile, Long> {
}
