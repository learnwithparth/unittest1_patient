package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Patient {
    @Id
    private long PatientId;
    private String name;
    private Integer age;

    private String address;
    public Patient(Integer id, String name, String address, Integer age) {
        this.PatientId= id;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getPatientId() {
        return Math.toIntExact(PatientId);
    }

    public void setPatientId(Integer patientId) {
        PatientId = patientId;
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
