package com.polyclinic.polyclinic.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DiagnoseDto {
    @NotNull
    private Long id;
    private String diagnosisName;
}
