package com.example.demo;

import com.example.demo.controller.PatientRecordController;
import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRecordRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@WebMvcTest(PatientRecordController.class)
public class PatientRecordControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;



    @MockBean
    PatientRecordRepository patientRecordRepository;

    Patient RECORD_1 = new Patient(1l, "Rayven Yor", 23, "Cebu Philippines");
    Patient RECORD_2 = new Patient(2l, "David Landup", 27, "New York USA");
    Patient RECORD_3 = new Patient(3l, "Jane Doe", 31, "New York USA");

    @Test
    public void getAllRecords_success() throws Exception {
        List<Patient> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

        Mockito.when(patientRecordRepository.findAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/patient")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].name", is("Jane Doe")));
    }

    @Test
    public void getPatientById_success() throws Exception {
        Mockito.when(patientRecordRepository.findById(RECORD_1.getPatientId())).thenReturn(java.util.Optional.of(RECORD_1));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/patient/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("Rayven Yor")));
    }

    @Test
    public void createRecord_success() throws Exception {
        Patient record = Patient.builder()
                .name("John Doe")
                .age(47)
                .address("New York USA")
                .build();

        Mockito.when(patientRecordRepository.save(record)).thenReturn(record);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/patient")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(record));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("John Doe")));
    }

    @Test
    public void updatePatientRecord_success() throws Exception {
        Patient updatedRecord = Patient.builder()
                .patientId(1l)
                .name("Rayven Zambo")
                .age(23)
                .address("Cebu Philippines")
                .build();

        Mockito.when(patientRecordRepository.findById(RECORD_1.getPatientId())).thenReturn(Optional.of(RECORD_1));
        Mockito.when(patientRecordRepository.save(updatedRecord)).thenReturn(updatedRecord);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/patient")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(updatedRecord));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("Rayven Zambo")));
    }

    @Test
    public void deletePatientById_success() throws Exception {
        Mockito.when(patientRecordRepository.findById(RECORD_2.getPatientId())).thenReturn(Optional.of(RECORD_2));

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/patient/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
