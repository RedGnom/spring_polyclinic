package com.polyclinic.polyclinic.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "doctor_profile")
public class DoctorProfile {
    @Id
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

}
