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

    @GetMapping("/listPatientRecords")
    public List<PatientRecord> getAllPatients(){
        return patientRecordRepository.findAll();

    }

    @GetMapping("/patientrecord/{id}")
    public  PatientRecord getPatient(@PathVariable Integer id){
        return patientRecordRepository.findById(id).get();
    }

    @DeleteMapping("/patientrecord/{id}")
    public List<PatientRecord> deletePatient(@PathVariable Integer id){
    patientRecordRepository.delete(patientRecordRepository.findById(id).get());
    return patientRecordRepository.findAll();
    }

    @PostMapping("/patientrecord")
    public List<PatientRecord> addPatient(@RequestBody PatientRecord patientRecord){
patientRecordRepository.save(patientRecord);
return patientRecordRepository.findAll();
    }

    @PutMapping("/patientrecord/{id}")
    public List<PatientRecord> updatePatient(@RequestBody PatientRecord patientRecord,@PathVariable Integer id){
        PatientRecord patientRecordObj = patientRecordRepository.findById(id).get();
    patientRecordObj.setName(patientRecordObj.getName());
    patientRecordObj.setAddress(patientRecordObj.getAddress());
    patientRecordObj.setAge(patientRecordObj.getAge());
patientRecordRepository.save(patientRecordObj);
return patientRecordRepository.findAll();

    }

    



}
