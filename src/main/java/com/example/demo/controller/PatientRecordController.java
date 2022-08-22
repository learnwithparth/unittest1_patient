package com.example.demo.controller;

import com.example.demo.model.PatientRecord;
import com.example.demo.repository.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class PatientRecordController {

    @Autowired
    PatientRecordRepository patientRecordRepository;

    @GetMapping("/getpatient/{id}")
    public PatientRecord getPatient(@PathVariable Long id){
        return patientRecordRepository.findById(Math.toIntExact(id)).get();
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
    public List<PatientRecord> deletePatient(@PathVariable Long patientId){
        patientRecordRepository.delete(patientRecordRepository.findById(Math.toIntExact(patientId)).get());
        return patientRecordRepository.findAll();
    }

    @PutMapping("/updatepatient/{id}")
    public List<PatientRecord> updatePatient(@RequestBody PatientRecord precord,@PathVariable Long patientId){
        PatientRecord patientRecord = patientRecordRepository.findById(Math.toIntExact(patientId)).get();
        patientRecord.setName(precord.getName());
        patientRecord.setAddress(precord.getName());
        patientRecordRepository.save(patientRecord);
        return patientRecordRepository.findAll();
    }
}
