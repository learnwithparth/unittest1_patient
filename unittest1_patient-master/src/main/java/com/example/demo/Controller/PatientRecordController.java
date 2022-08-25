package com.example.demo.Controller;

import com.example.demo.Model.PatientRecord;
import com.example.demo.Repository.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patients")
@CrossOrigin(origins="http://localhost:3000")
public class PatientRecordController {

    @Autowired
    private PatientRecordRepository patientRecordRepository;

    //    get all data from the db
    @GetMapping
    public List<PatientRecord> getAllPatients(){
        return patientRecordRepository.findAll();
    }

    //    build and create a patient REST API
    @PostMapping
    public PatientRecord createPatient(@RequestBody PatientRecord patientRecord){
        return patientRecordRepository.save(patientRecord);
    }

    //    build get employee by id REST API
// Get the patient information
    @GetMapping("{id}")
    public PatientRecord getPatient(@PathVariable Long id) {
        return patientRecordRepository.findById(id).get();
    }

    // Update the patient information
    @PutMapping("{id}")
    public List<PatientRecord> updatePatient(@RequestBody PatientRecord patientRecord, @PathVariable Long id) {
        PatientRecord patienObj = patientRecordRepository.findById(id).get();
        patienObj.setId(patientRecord.getId());
        patienObj.setName(patientRecord.getName());
        patienObj.setAge(patientRecord.getAge());
        patienObj.setAddress(patientRecord.getAddress());
        patientRecordRepository.save(patienObj);
        return patientRecordRepository.findAll();
    }

    // Delete the student
    @DeleteMapping("{id}")
    public List<PatientRecord> deletePatient(@PathVariable Long id) {
        patientRecordRepository.delete(patientRecordRepository.findById(id).get());
        return patientRecordRepository.findAll();
    }



}
