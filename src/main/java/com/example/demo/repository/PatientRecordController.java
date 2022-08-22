package com.patient.patient.repository;

import com.patient.patient.model.PatientRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRecordController extends JpaRepository<PatientRecord,Integer> {
}
