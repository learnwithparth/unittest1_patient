package com.example.demo.model;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
public class PatientRecord {

    @Id
    private Long patientId;
    private String name;
    private Integer age;

    private String address;

    public PatientRecord()
    {

    }

    public PatientRecord(Long PatientId, String name, Integer age,String address) {
       this.patientId = PatientId;
     this.name = name;
     this.age=age;
     this.address = address;
    }

    public void setId(Long id) {
        this.patientId = id;
    }

    public Long getPatientId()
    {
        return patientId;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
