package com.example.demo.Controller;

import com.example.demo.Repositories.PatientRecordRepository;
import com.example.demo.models.PatientRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Autowired
    PatientRecordRepository patientRecordRepository;

@RestController
public class patientRecordController {

    @GetMapping("/patient")
    public List<PatientRecord> get_patient(){
        return PatientRecordRepository.findAll();
    }

    @DeleteMapping("/patient/{id}")
    public List<PatientRecord> delete_patient(@PathVariable Integer id){
        PatientRecordRepository.delete(PatientRecordRepository.findById(id).get());
        return PatientRecordRepository.findAll();
    }

    @PostMapping("/patient")
    public List<PatientRecord> addpatient(@RequestBody PatientRecord patient){
        PatientRecordRepository.save(patient);
        return PatientRecordRepository.findAll();
    }

    @PutMapping("/patient/{id}")
    public List<PatientRecord> updatepatient(@RequestBody PatientRecord patient,@PathVariable Integer id){
        PatientRecord patientobj = PatientRecordRepository.findById(id).get();
        patientobj.setId(PatientRecord.getId());
        PatientRecordRepository.save(patientobj);
        return PatientRecordRepository.findAll();
    }
}

