package com.example.demo.controllers;

import com.example.demo.Repository.PatientRecordRepository;
import com.example.demo.model.PatientRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PatientRecordController {

    @Autowired
    PatientRecordRepository patientRecordRepository;

    @GetMapping("/patient")
    public List<PatientRecord> getAllPatientRecords() {
        return patientRecordRepository.findAll();
    }

    @GetMapping("/patientRecord/{id}")
    public PatientRecord getPatientRecord(@PathVariable Long id) {
        return patientRecordRepository.findById(id).get();
    }

    // Delete the patientRecord
    @DeleteMapping("/patientRecord/{id}")
    public List<PatientRecord> deletePatientRecord(@PathVariable Long id) {
        patientRecordRepository.delete(patientRecordRepository.findById(id).get());
        return patientRecordRepository.findAll();
    }

    // Add new patientRecord
    @PostMapping("/patientRecord")
    public List<PatientRecord> addPatientRecord(@RequestBody PatientRecord patientRecord) {
        patientRecordRepository.save(patientRecord);
        return patientRecordRepository.findAll();
    }

    // Update the patientRecord information
    @PutMapping("/patientRecord/{id}")
    public List<PatientRecord> updatePatientRecord(@RequestBody PatientRecord patientRecord, @PathVariable Long id) {
        PatientRecord patientRecordObj = patientRecordRepository.findById(id).get();
        patientRecordObj.setName(patientRecord.getName());
        patientRecordObj.setAddress(patientRecord.getAddress());
        patientRecordRepository.save(patientRecordObj);
        return patientRecordRepository.findAll();
    }

}
