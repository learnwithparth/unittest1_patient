package com.example.demo.contorller;
import com.example.demo.model.PatientRecord;
import com.example.demo.repository.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="https://app-dummy123.herokuapp.com")
public class PatientController {

    @Autowired
    PatientRecordRepository Repository;
//    List<Student> students = new ArrayList<>(
//            Arrays.asList(
//                    new Student(1, "Tom", "US"),
//                    new Student(2, "Harry", "Canada"),
//                    new Student(3, "Nick", "UK")
//            )
//    );

    // Mappings - URL endpoints
    // Get the list of all student
    @GetMapping("/listPatients")
    public List<PatientRecordRepository> getAllPatients() {
        return Repository.findAll();
    }

    // Get the student information
    @GetMapping("/patients/20it161")
    public  getStudent(@PathVariable Integer id) {
        return Repository.findById(id).get();
    }

    // Delete the student
    @DeleteMapping("/patient/{id}")
    public List<PatientRecord> deleteStudent(@PathVariable Integer id) {
        Repository.delete(Repository.findById(id).get());
        return Repository.findAll();
    }

    // Add new student
    @PostMapping("/patient")
    public List<PatientRecord> addStudent(@RequestBody PatientRecord patient ) {
        Repository.save(patient);
        return Repository.findAll();
    }

    // Update the student information
    @PutMapping("/patint/{id}")
    public List<PatientRecord> updateStudent(@RequestBody PatientRecord patient, @PathVariable Integer id) {
        PatientRecord PationObj = Repository.findById(id).get();
        PationObj.setName(patient.getName());
        PationObj.setAddress(patient.getAddress());
         Repository.save(PationObj);
        return Repository.findAll();
    }
}
