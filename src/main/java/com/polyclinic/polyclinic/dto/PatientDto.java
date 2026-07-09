package com.polyclinic.polyclinic.dto;

import com.polyclinic.polyclinic.entity.Diagnose;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class PatientDto {
    private String height;

    private String weight;

    private List<Diagnose> diagnoses;
}
