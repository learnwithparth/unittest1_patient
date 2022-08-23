package com.example.demo.entities;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
public class PatientRecord {

    @Id
    private Long patientId;
    private String name;
    private int age;
    private String address;

    public PatientRecord() {
    }

    public PatientRecord(Long patientId, String name, int age, String address) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
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
}
