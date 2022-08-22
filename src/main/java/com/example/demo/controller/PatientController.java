package com.patient.patient.controller;


import com.patient.patient.model.PatientRecord;
import com.patient.patient.repository.PatientRecordController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PatientController {

    @Autowired
    PatientRecordController patientRecordController;

    @GetMapping("/patient")
    public List<PatientRecord> getAllStudents() {
        return patientRecordController.findAll();
    }



    // Get the student information
    @GetMapping("/patient/{id}")
    public PatientRecord getPatient(@PathVariable Integer id) {
        return patientRecordController.findById(id).get();
    }

    // Delete the student
    @DeleteMapping("/patient/{id}")
    public List<PatientRecord> deletePatient(@PathVariable Integer id) {
        patientRecordController.delete(patientRecordController.findById(id).get());
        return patientRecordController.findAll();
    }

    // Add new student
    @PostMapping("/patient")
    public List<PatientRecord> addPatient(@RequestBody PatientRecord PatientRecord) {
        patientRecordController.save(PatientRecord);
        return patientRecordController.findAll();
    }

    // Update the student information
    @PutMapping("/patient/{id}")
    public List<PatientRecord> updatePatient(@RequestBody PatientRecord patient, @PathVariable Integer id) {
        PatientRecord patientObj = patientRecordController.findById(id).get();
        patientObj.setName(PatientRecord.getName());
        patientObj.setAddress(PatientRecord.getAddress());
        patientRecordController.save(patientObj);
        return patientRecordController.findAll();
    }


}


