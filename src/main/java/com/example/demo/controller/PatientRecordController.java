package com.example.demo.controller;

import com.example.demo.model.PatientRecord;
import com.example.demo.repository.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PatientRecordController {
    @Autowired
    PatientRecordRepository patientRecordRepository;

    @GetMapping("/patient")
    public List<PatientRecord> getAllPatientRecord() {return patientRecordRepository.findAll();}

    // Get the student information
    @GetMapping("/patient/{patientId}")
    public PatientRecord getAllPatientRecord(@PathVariable Long patientId) {return patientRecordRepository.findById(patientId).get();}

    // Delete the student
    @DeleteMapping("/patient/{patientId}")
    public List<PatientRecord> deletePatientRecord(@PathVariable Long patientId) {
        patientRecordRepository.delete(patientRecordRepository.findById(patientId).get());
        return patientRecordRepository.findAll();
    }

    // Add new student
    @PostMapping("/patient")
    public List<PatientRecord> addPatientRecord(@RequestBody PatientRecord patientRecord) {
        patientRecordRepository.save(patientRecord);
        return patientRecordRepository.findAll();
    }

    // Update the student information
    @PutMapping("/patient/{patientId}")
    public List<PatientRecord> updatePatientRecord(@RequestBody PatientRecord patientRecord, @PathVariable Long patientId) {
        PatientRecord patientRecordObj = patientRecordRepository.findById(patientId).get();
        patientRecordObj.setName(patientRecord.getName());
        patientRecordObj.setAge(patientRecord.getAge());
        patientRecordObj.setAddress(patientRecord.getAddress());
        patientRecordRepository.save(patientRecordObj);
        return patientRecordRepository.findAll();
    }

}
