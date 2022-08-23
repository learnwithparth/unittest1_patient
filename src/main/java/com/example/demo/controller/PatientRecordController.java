package com.example.demo.controller;

import com.example.demo.entity.PatientRecord;
import com.example.demo.repository.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class PatientRecordController {

    @Autowired
    PatientRecordRepository patientRecordRepository;
    @GetMapping("/patient")
    public List<PatientRecord> getAllpatient() {
        return patientRecordRepository.findAll();
    }


    @GetMapping("/patient/{patientId}")
    public PatientRecord getPatient(@PathVariable Long patientId) {
        return patientRecordRepository.findById(patientId).get();
    }

    @PostMapping("/addPatient")
    public List<PatientRecord> addPatient(@RequestBody PatientRecord patientRecord) {
        patientRecordRepository.save(patientRecord);
        return patientRecordRepository.findAll();
    }

    @PutMapping("/patientupdate/{patientId}")
    public List<PatientRecord> updatepatient(@RequestBody PatientRecord patientRecord, @PathVariable Long patientId) {
        PatientRecord patientObj = patientRecordRepository.findById(patientId).get();
        patientObj.setName(patientRecord.getName());
        patientObj.setAddress(patientRecord.getAddress());
        patientRecordRepository.save(patientObj);
        return patientRecordRepository.findAll();
    }

    @DeleteMapping("/patientDelete/{patientId}")
    public List<PatientRecord> deletepatient(@PathVariable Long patientId) {
        patientRecordRepository.delete(patientRecordRepository.findById(patientId).get());
        return patientRecordRepository.findAll();
    }
}
