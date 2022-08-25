package com.example.demo.Controller;

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
    public List<PatientRecord> getAllPatients(){
        return patientRecordRepository.findAll();
    }

    @GetMapping("/patient/{patientId}")
    public PatientRecord getPatient(@PathVariable Long patientId){
        return patientRecordRepository.findById(patientId).get();
    }

    @PostMapping("/patient")
    public List<PatientRecord> addPatient(@RequestBody PatientRecord patientRecord){
        patientRecordRepository.save(patientRecord);
        return patientRecordRepository.findAll();
    }

    @PutMapping("updatepatient/{patientId}")
    public List<PatientRecord> updatePatient(@RequestBody PatientRecord patientRecord,@PathVariable Long patientId){
        PatientRecord patientRecordObj =patientRecordRepository.findById(patientId).get();
        patientRecordObj.setName(patientRecord.getName());
        patientRecordObj.setAge(patientRecord.getAge());
        patientRecordObj.setAddress(patientRecord.getAddress());
        patientRecordRepository.save(patientRecordObj);
        return patientRecordRepository.findAll();
    }

    @DeleteMapping("/patient/{patientId}")
    public List<PatientRecord> deletePatient(@PathVariable Long patientId){
        patientRecordRepository.delete(patientRecordRepository.findById(patientId).get());
        return patientRecordRepository.findAll();
    }
}
