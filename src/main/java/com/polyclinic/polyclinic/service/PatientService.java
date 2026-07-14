package com.polyclinic.polyclinic.service;

import com.polyclinic.polyclinic.dto.DiagnoseDto;
import com.polyclinic.polyclinic.dto.PatientDto;
import com.polyclinic.polyclinic.dto.UserDto;
import com.polyclinic.polyclinic.entity.Diagnose;
import com.polyclinic.polyclinic.entity.PatientProfile;
import com.polyclinic.polyclinic.entity.User;
import com.polyclinic.polyclinic.exception.PatientProfileNotFoundException;
import com.polyclinic.polyclinic.mapper.PatientProfileMapper;
import com.polyclinic.polyclinic.repository.DiagnoseRepository;
import com.polyclinic.polyclinic.repository.PatientProfileRepository;
import com.polyclinic.polyclinic.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientProfileRepository patientRepository;
    private final UserService userService;
    private final PatientProfileMapper patientMapper;
    private final DiagnoseRepository diagnoseRepository;

    // Получение профиля пациента с диагнозами
    public PatientDto getPatientProfileDto(Long userId){
        PatientProfile profile = patientRepository.findByIdWithDiagnoses(userId)
                .orElseThrow(() -> new PatientProfileNotFoundException("Не найден профиль пациента " + userId));
        return patientMapper.toPatientDto(profile);
    }

    // Создание профиля
    @Transactional
    public PatientProfile createPatientProfile(Long userId, PatientDto dto){

        if(patientRepository.existsByUserId(userId)){
            throw new IllegalStateException("У пользователя уже есть профиль пациента");
        }
        User user = userService.getUserById(userId);

        // Создаем профиль пациента
        PatientProfile profile = new PatientProfile();
        profile.setUser(user);

        // Заполняем вес и рост
        profile = patientMapper.toPatientProfileEntity(dto);

        if (dto.getDiagnoses() != null) {
            List<Diagnose> diagnoses = new ArrayList<>();
            for (DiagnoseDto diagnoseDto : dto.getDiagnoses()){
                Diagnose diagnose;

                diagnose = diagnoseRepository.findById(diagnoseDto.getId())
                        .orElseThrow(() -> new EntityNotFoundException("Диагноз не найден"));

                diagnoses.add(diagnose);
            }
            profile.setDiagnoses(diagnoses);
        }

        return profile;
    }
    public void deletePatientProfile(Long userId){
        PatientProfile profile = patientRepository.findById(userId)
                .orElseThrow(() -> new PatientProfileNotFoundException("Не найден профиль пациента " + userId));

        patientRepository.deleteById(userId);


    }

}
