package com.example.demo.model;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
public class PatientRecord {
    @Id
    private Long patientId;

    public PatientRecord() {
    }

    private String name;
    private int age;

    public Long getPatientId() {
        return patientId;
    }

    public PatientRecord(Long patientId, String name, int age, String address) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.address = address;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;


}
