package controllers;

import Repository.PatientRecordRepository;
import model.PatientRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PatientRecordController {

    @Autowired
    PatientRecordRepository patientRecordRepository;

    @GetMapping("/listPatients")
    public List<PatientRecord> getAllPatientRecord() {
        return patientRecordRepository.findAll();
    }

    // Get the student information
    @GetMapping("/PatientRecord/{patientId}")
    public PatientRecord getPatientRecord(@PathVariable Integer patientId) {
        return patientRecordRepository.findById(patientId).get();
    }

    // Delete the student
    @DeleteMapping("/PatientRecord/{patientId}")
    public List<PatientRecord> deletePatientRecord(@PathVariable Integer patientId) {
        patientRecordRepository.delete(patientRecordRepository.findById(patientId).get());
        return patientRecordRepository.findAll();
    }

    // Add new student
    @PostMapping("/PatientRecord")
    public List<PatientRecord> addPatientRecord(@RequestBody PatientRecord PatientRecord) {
        patientRecordRepository.save(PatientRecord);
        return patientRecordRepository.findAll();
    }

    // Update the student information
    @PutMapping("/PatientRecord/{patientId}")
    public List<PatientRecord> updatePatientRecord(@RequestBody PatientRecord PatientRecord, @PathVariable Integer patientId) {
        PatientRecord patientObj = patientRecordRepository.findById(patientId).get();
        patientObj.setName(PatientRecord.getName());
        patientObj.setAddress(PatientRecord.getAddress());
        patientRecordRepository.save(patientObj);
        return patientRecordRepository.findAll();
    }
}
