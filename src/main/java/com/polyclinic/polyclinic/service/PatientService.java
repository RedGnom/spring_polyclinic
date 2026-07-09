package com.polyclinic.polyclinic.service;

import com.polyclinic.polyclinic.dto.PatientDto;
import com.polyclinic.polyclinic.dto.UserDto;
import com.polyclinic.polyclinic.entity.PatientProfile;
import com.polyclinic.polyclinic.entity.User;
import com.polyclinic.polyclinic.mapper.PatientProfileMapper;
import com.polyclinic.polyclinic.repository.PatientProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientProfileRepository patientRepository;
    private final PatientProfileMapper patientMapper;

    // Получение профиля пациента с диагнозами
    public PatientDto getPatientProfile(Long id){
        PatientProfile profile = patientRepository.findByIdWithDiagnoses(id)
                .orElseThrow();
        return patientMapper.toPatientDto(profile);
    }

}
