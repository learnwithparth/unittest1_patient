package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

    @Entity
    public class PatientRecord {

        @Id
        private Integer age;
        private Integer id;
        private String name;
        private String address;

        public PatientRecord(Integer id, Integer age,String name, String address) {
            this.id = id;
            this.age = age;
            this.name = name;
            this.address = address;
        }

        public PatientRecord() {

        }

        public PatientRecord(long l, String rayven_yor, int i, String cebu_philippines) {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
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

