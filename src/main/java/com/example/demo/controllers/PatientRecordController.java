package com.example.demo.controllers;

import com.example.demo.model.PatientRecord;
import com.example.demo.repositories.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientRecordController {

    @Autowired
    PatientRecordRepository patientRecordRepository;

    @GetMapping("/listPatient")
    public List<PatientRecord> getAllPatients() {

        return patientRecordRepository.findAll();
    }

    @GetMapping("/patient/{patientId}")
    public PatientRecord getPatient(@PathVariable Integer patientId) {

        return patientRecordRepository.findById(patientId).get();
    }

    @DeleteMapping("/patient/{id}")
    public List<PatientRecord> deletePatient(@PathVariable Integer patientId) {
        patientRecordRepository.delete(patientRecordRepository.findById(patientId).get());
        return patientRecordRepository.findAll();
    }

    @PostMapping("/patient")
    public List<PatientRecord> addPatient(@RequestBody PatientRecord patientRecord) {
        patientRecordRepository.save(patientRecord);
        return patientRecordRepository.findAll();
    }

    @PutMapping("/patient/{patientId}")
    public List<PatientRecord> updatePatient(@RequestBody PatientRecord patientRecord, @PathVariable Integer patientId) {
        PatientRecord patientObj = patientRecordRepository.findById(patientId).get();
        patientObj.setName(patientRecord.getName());
        patientObj.setAddress(patientRecord.getAddress());
        patientObj.setAge(patientRecord.getAge());
        patientRecordRepository.save(patientObj);
        return patientRecordRepository.findAll();
    }
}
