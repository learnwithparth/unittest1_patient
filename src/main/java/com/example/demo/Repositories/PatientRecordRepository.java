package com.example.demo.Repositories;

import com.example.demo.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRecordRepository extends JpaRepository<Patient,Long> {
}
