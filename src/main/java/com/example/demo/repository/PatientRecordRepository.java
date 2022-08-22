package com.example.demo.repository;

import com.example.demo.Model.PatientRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRecordRepository  extends JpaRepository<PatientRecord,Long> {
}