package com.patient.patient.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PatientRecord {
    @Id
    private int id;
    private static String name;
    private static String address;
    private static String age;

    public PatientRecord() {
    }

    public PatientRecord(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public static String getAge() {
        return age;
    }

    public static void setAge(String age) {
        PatientRecord.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
