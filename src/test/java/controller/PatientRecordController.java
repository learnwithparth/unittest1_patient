package controller;

import Repository.PatientRecordRepository;
import model.PatientRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PatientRecordController {

    @Autowired
    PatientRecordRepository patientRecordRepository;

    @GetMapping("/listPatient")
    public List<PatientRecord> getAllPatientRecode() {

        return patientRecordRepository.findAll();
    }

    // Get the student information
    @GetMapping("/PatientRecord/{PatientId}")
    public PatientRecord getPatientRecord(@PathVariable Integer PatientId) {

        return patientRecordRepository.findById(PatientId).get();
    }

    // Delete the student
    @DeleteMapping("/PatientRecord/{PatientId}")
    public List<PatientRecord> deletePatientRecord(@PathVariable Integer PatientId) {
        patientRecordRepository.delete(patientRecordRepository.findById(PatientId).get());
        return patientRecordRepository.findAll();
    }

    // Add new student
    @PostMapping("/PatientRecord")
    public List<PatientRecord> addPatientRecord(@RequestBody PatientRecord PatientRecord) {
        patientRecordRepository.save(PatientRecord);
        return patientRecordRepository.findAll();
    }

    // Update the student information
    @PutMapping("/PatientRecord/{PatientId}")
    public List<PatientRecord> updatePatientRecord(@RequestBody PatientRecord PatientRecord, @PathVariable Integer PatientId) {
        PatientRecord PatientRecordObj = patientRecordRepository.findById(PatientId).get();
        PatientRecordObj.setName(PatientRecord.getName());
        PatientRecordObj.setAddress(PatientRecord.getAddress());
        patientRecordRepository.save(PatientRecordObj);
        return patientRecordRepository.findAll();
    }
}
