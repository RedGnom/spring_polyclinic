package com.polyclinic.polyclinic.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class PatientDto {
    private Double height;

    private Double weight;

    private List<DiagnoseDto> diagnoses;
}
