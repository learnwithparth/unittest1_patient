package com.example.demo.Model;

import javax.persistence.Id;

import javax.persistence.Entity;

@Entity
public class Patient {

    @Id
    private Integer patientId;

    private String name;

    private String address;

    public Patient(Integer patientId, String name, String address) {
        this.patientId = patientId;
        this.name = name;
        this.address = address;
    }

    public Patient(){

    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
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
