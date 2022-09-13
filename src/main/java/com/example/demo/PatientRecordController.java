package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")

public class PatientRecordController {
    @Autowired
    PatientRecordRepository patientRecordRepository;

    @GetMapping("/patient")
    public List<PatientRecord> getAllPatient() {
        return patientRecordRepository.findAll();
    }

    // Get the student information
    @GetMapping("/patient/{patientId}")
    public PatientRecord getPatient(@PathVariable Integer id) {
        return patientRecordRepository.findById(id).get();
    }

    // Delete the student
    @DeleteMapping("/patient/{patientId}")
    public List<PatientRecord> deletePatient(@PathVariable Integer id) {
        patientRecordRepository.delete(patientRecordRepository.findById(id).get());
        return patientRecordRepository.findAll();
    }

    // Add new student
    @PostMapping("/patient")
    public List<PatientRecord> addPatient(@RequestBody PatientRecord student) {
        patientRecordRepository.save(student);
        return patientRecordRepository.findAll();
    }

    // Update the student information
    @PutMapping("/patient/{patientId}")
    public List<PatientRecord> updatePatient(@RequestBody PatientRecord student, @PathVariable Integer id) {
        PatientRecord patientObj = patientRecordRepository.findById(id).get();
        patientObj.setName(student.getName());
        patientObj.setAddress(student.getAddress());
        patientRecordRepository.save(patientObj);
        return patientRecordRepository.findAll();
    }
}
