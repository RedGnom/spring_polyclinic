package com.polyclinic.polyclinic.mapper;

import com.polyclinic.polyclinic.dto.PatientDto;
import com.polyclinic.polyclinic.entity.PatientProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PatientProfileMapper {
    PatientDto toPatientDto(PatientProfile profile);

    @Mapping(target = "user", ignore = true) // Вручную подставляем в сервисе
    @Mapping(target = "diagnoses", ignore = true) // Диагнозы тоже в сервисе
    PatientProfile toPatientProfileEntity(PatientDto dto);


}
