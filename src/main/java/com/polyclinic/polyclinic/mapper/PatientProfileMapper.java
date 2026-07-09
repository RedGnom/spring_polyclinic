package com.polyclinic.polyclinic.mapper;

import com.polyclinic.polyclinic.dto.PatientDto;
import com.polyclinic.polyclinic.entity.PatientProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientProfileMapper {
    PatientDto toPatientDto(PatientProfile profile);
}
