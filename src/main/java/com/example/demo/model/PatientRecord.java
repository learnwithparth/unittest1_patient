package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PatientRecord {

    @Id
    private Integer name;

    private String address;

    public Integer getName() {
        return name;
    }

    public PatientRecord() {
    }

    public PatientRecord(Integer name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
