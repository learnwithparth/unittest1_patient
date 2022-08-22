package com.example.demo.controllers;

import com.example.demo.entinty.PatientRecord;
import com.example.demo.repositories.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="https://localhost:3000")
public class PatientRecordController {


    @Autowired
    PatientRecordRepository patientRecordRepository;

    @GetMapping("/patient")
    public List<PatientRecord> getAllPatient(){
        return patientRecordRepository.findAll();
    }

    @GetMapping("/patient/{patientId}")
    public PatientRecord getPatient(@PathVariable Integer id ){
        return patientRecordRepository.findById(id).get();
    }

    @PostMapping("/patient")
    public List<PatientRecord> addPatient(@RequestBody PatientRecord patientRecord){
        patientRecordRepository.save(patientRecord);
        return patientRecordRepository.findAll();
    }

    @PutMapping("/patient/{patientId}")
    public List<PatientRecord> updatePatient(@RequestBody PatientRecord patientRecord,@PathVariable Integer id){
        PatientRecord patientRecord1 = patientRecordRepository.findById(id).get();
        patientRecord1.setName(patientRecord.getName());
        patientRecord1.setAddress(patientRecord.getAddress());
        patientRecordRepository.save(patientRecord1);

        return patientRecordRepository.findAll();
    }

    @DeleteMapping("/patient/{patientId}")
    public List<PatientRecord> deletePatient(@PathVariable Integer id){
        patientRecordRepository.delete(patientRecordRepository.findById(id).get());
        return  patientRecordRepository.findAll();
    }



}
