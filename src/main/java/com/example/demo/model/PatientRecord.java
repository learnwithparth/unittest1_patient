package com.example.demo.model;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
public class PatientRecord {

    @Id
    private Long id;

    private Integer age;

    public PatientRecord()
    {

    }

    public PatientRecord(Long id, String name, Integer age,String address) {
       this.id = id;
     this.name = name;
     this.age=age;
     this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId()
    {
        return id;
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

    private String name;
    private String address;



}
