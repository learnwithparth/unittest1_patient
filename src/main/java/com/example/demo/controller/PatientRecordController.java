package com.example.demo.controller;

import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientRecordController {
    @Autowired
    PatientRecordRepository patientRecordRepository;

    @GetMapping("/patient")
    public List<Patient> getPatient() {
        return patientRecordRepository.findAll();
    }

    @GetMapping("/patient/{id}")
    public Patient getPatient(@PathVariable Long id) {
        return patientRecordRepository.findById(id).get();
    }
    @PostMapping("/patient")
    public List<Patient> addPatient(@RequestBody Patient patient) {
        patientRecordRepository.save(patient);
        return patientRecordRepository.findAll();
    }

    @PutMapping("/patient/{id}")
    public List<Patient> updatePatient(@RequestBody Patient patient, @PathVariable Long id) {
        Patient patientObj = patientRecordRepository.findById(id).get();
        patientObj.setName(patient.getName());
        patientObj.setAddress(patient.getAddress());
        patientRecordRepository.save(patientObj);
        return patientRecordRepository.findAll();
    }

    @DeleteMapping("/patient/{id}")
    public List<Patient> deleteStudent(@PathVariable Long id) {
        patientRecordRepository.delete(patientRecordRepository.findById(id).get());
        return patientRecordRepository.findAll();
    }
}
