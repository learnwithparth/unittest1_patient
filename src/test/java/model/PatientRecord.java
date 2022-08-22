package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PatientRecord {
    @Id
    private Integer patientId;
    private String name;
    private String address;

    public PatientRecord(Integer patientId, String name, String address) {
        this.patientId = patientId;
        this.name = name;
        this.address = address;
    }

    public PatientRecord() {

    }

    public static <E> Enum<E> builder() {
    }

    public Integer getId() {

        return patientId;
    }

    public void setId(Integer patientId) {

        this.patientId = patientId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }


    public Integer getPatientId() {
    }
}
}
