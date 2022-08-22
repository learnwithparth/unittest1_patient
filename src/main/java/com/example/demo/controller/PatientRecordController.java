package com.example.demo.controller;

import com.example.demo.model.PatientRecord;
import com.example.demo.repository.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientRecordController {
    @Autowired
    com.example.demo.repository.PatientRecordRepository patientRepository;

    @GetMapping("/patient")
    public List<PatientRecord> listPatient(){
        return patientRepository.findAll();
    }

    @GetMapping("/patient/{patientId}")
    public PatientRecord getStudent(@PathVariable Long patientId) {
        return patientRepository.findById(patientId.intValue()).get();
    }

    @PostMapping("/patient")
    public List<PatientRecord> addStudent(@RequestBody PatientRecord patientrecord) {
        patientRepository.save(patientrecord);
        return patientRepository.findAll();
    }

    @DeleteMapping("/patient/{patientId}")
    public List<PatientRecord> deleteStudent(@PathVariable Long patientId) {
        //patientRepository.delete(patientRepository.findById(id).get());
        patientRepository.deleteById(patientId.intValue());
        return patientRepository.findAll();
    }

    @PutMapping("/patient/{patientId}")
    public List<PatientRecord> updateStudent(@RequestBody PatientRecord patientrecord, @PathVariable Long patientId) {
        PatientRecord patientObj = patientRepository.findById(patientId.intValue()).get();
        patientObj.setName(patientrecord.getName());
        patientObj.setAddress(patientrecord.getAddress());
        patientRepository.save(patientObj);
        return patientRepository.findAll();
    }
}
