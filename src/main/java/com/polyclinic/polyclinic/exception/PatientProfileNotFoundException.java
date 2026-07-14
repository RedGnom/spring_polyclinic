package com.polyclinic.polyclinic.exception;

public class PatientProfileNotFoundException extends RuntimeException{
    public PatientProfileNotFoundException(String message){
        super(message);
    }
}
