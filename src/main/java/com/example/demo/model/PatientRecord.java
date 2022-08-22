package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PatientRecord {
    @Id
    private Long patientId;
    private String name;
    private Long age;
    private String address;

    public PatientRecord(){
    }
    public PatientRecord(Long patientId, String name, String address){
        this.patientId = patientId;
        this.name = name;
        this.address = address;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}