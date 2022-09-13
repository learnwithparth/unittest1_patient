package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRecordRepository extends JpaRepository<PatientRecord, Integer> {

}
