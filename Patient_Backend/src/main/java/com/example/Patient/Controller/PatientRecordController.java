package com.example.Patient.Controller;

import com.example.Patient.Model.PatientRecord;
import com.example.Patient.Repository.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patient")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientRecordController {
    @Autowired
    private PatientRecordRepository patientRecordRepository;

    @GetMapping
    public List<PatientRecord> getAllPatients(){
        return patientRecordRepository.findAll();
    }

    @GetMapping("{id}")
    public PatientRecord getPatient(@PathVariable Long id){
        return patientRecordRepository.findById(id.compareTo(id)).get();
    }

    @PutMapping("{id}")
    public List<PatientRecord> updatePatient(@RequestBody PatientRecord patientRecord, @PathVariable Integer id){
        PatientRecord patientRecordObj = patientRecordRepository.findById(id).get();
        patientRecordObj.setAge(patientRecord.getAge());
        patientRecordObj.setName(patientRecord.getName());
        patientRecordObj.setAddress(patientRecord.getAddress());
        patientRecordRepository.save(patientRecordObj);
        return patientRecordRepository.findAll();
    }

    @PostMapping
    public PatientRecord createPatient(@RequestBody PatientRecord patientRecord){
        return patientRecordRepository.save(patientRecord);
    }

    @DeleteMapping("{id}")
    public List<PatientRecord> deletePatient(@PathVariable Integer id){
        patientRecordRepository.delete(patientRecordRepository.findById(id).get());
        return patientRecordRepository.findAll();
    }
}
