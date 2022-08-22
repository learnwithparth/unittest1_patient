package com.example.demo.controller;

import com.example.demo.model.PatientRecord;
import com.example.demo.repositories.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("")
public class PatientRecordController {

    @Autowired
    PatientRecordRepository patientRecordRepository;

    @GetMapping("/getpatient/{id}")
    public PatientRecord getPatient(@PathVariable Integer id){
        return patientRecordRepository.findById(id).get();
    }

    @GetMapping("/getpatient")
    public List<PatientRecord> getAllPatient(){
        return patientRecordRepository.findAll();
    }

    @PostMapping("/postpatient")
    public List<PatientRecord> postPatient(@RequestBody PatientRecord patientRecord){
        patientRecordRepository.save(patientRecord);
        return patientRecordRepository.findAll();
    }

    @DeleteMapping("/deletepatient/{id}")
    public List<PatientRecord> deletePatient(@PathVariable Integer patientId){
        patientRecordRepository.delete(patientRecordRepository.findById(patientId).get());
        return patientRecordRepository.findAll();
    }

    @PutMapping("/updatepatient/{id}")
    public List<PatientRecord> updatePatient(@RequestBody PatientRecord precord,@PathVariable Integer patientId){
        PatientRecord patientRecord = patientRecordRepository.findById(patientId).get();
        patientRecord.setName(precord.getName());
        patientRecord.setAddress(precord.getName());
        patientRecordRepository.save(patientRecord);
        return patientRecordRepository.findAll();
    }
}