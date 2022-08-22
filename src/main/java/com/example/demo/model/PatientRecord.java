package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PatientRecord {

    @Id
    private Integer id;

    private String name;

    public static JsonSubTypes.Type builder() {
        return null;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    private Long age;

    private String address;

    public PatientRecord(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getPatientId() {
        return null;
    }
}
