package com.example.demo.controller;

import com.example.demo.model.PatientRecord;
import com.example.demo.repository.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "localhost://3000")
public class PatientRecordController {

    @Autowired
    PatientRecordRepository patientRecordRepository;

    @GetMapping("/")
    public String welcome(){
        return "Welcome to spring Boot";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello From Dhyey";
    }

    @GetMapping("/patients")
    public List<PatientRecord> getAllPatients(){
        return patientRecordRepository.findAll();
    }

    @GetMapping("/patient/{id}")
    public PatientRecord getpatient(@PathVariable Integer id){
        return patientRecordRepository.findById(id).get();
    }

    @PostMapping("/patient")
    public List<PatientRecord> addPatient(@RequestBody PatientRecord patient){
        patientRecordRepository.save(patient);
        return patientRecordRepository.findAll();
    }

    //Update employee information
    @PutMapping("patient/{id}")
    public List<PatientRecord> updatePatient(@RequestBody PatientRecord patient, @PathVariable Integer id){
        PatientRecord patientObj = patientRecordRepository.findById(id).get();
        patientObj.setName(patient.getName());
        patientObj.setAddress(patient.getAddress());

        patientRecordRepository.save(patientObj);
        return patientRecordRepository.findAll();
    }

    //Delete employee
    @DeleteMapping("/patient/{id}")
    public List<PatientRecord> deletePatient(@PathVariable Integer id){
        patientRecordRepository.delete(patientRecordRepository.findById(id).get());
        return patientRecordRepository.findAll();
    }
}
