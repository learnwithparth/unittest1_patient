import axios from "axios";
import React, { useEffect, useState } from "react";
import { Card, Container, Table, Button } from "react-bootstrap";

export default function ListPatient() {

    const [patient, setPatient] = useState([]);

    useEffect(() => {
        getStudents();
    }, []);

    let getStudents = () => {
        axios.get("http://localhost:8080/patient")
            .then(response => setPatient(response.data))
            .catch(error => alert(error));
    };

    let deleteRecord = (id) => {
        axios.delete("http://localhost:8080/patient/"+id)
            .then(response => {
                if(response.data != null)
                    alert("Record Deleted");
            });
    }

    return (
        <div className="my-3">
            <Container>
                <Card.Header><h3>Patients List</h3></Card.Header>
                <Card.Body>
                    <Table striped bordered hover>
                        <thead>
                        <tr>
                            <th>Patient Id</th>
                            <th>Patient Name</th>
                            <th>Patient Age</th>
                            <th>Patient Address</th>
                            <th>Edit/Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        {patient.map(patient => (
                            <tr>
                                <td>{patient.patientId}</td>
                                <td>{patient.name}</td>
                                <td>{patient.age}</td>
                                <td>{patient.address}</td>
                                <td>
                                    <Button variant="success">Edit</Button>{' '}
                                    <Button variant="primary" onClick ={ () => deleteRecord(patient.patientId)}>Delete</Button>{' '}
                                </td>
                            </tr>
                        ))}
                        </tbody>
                    </Table>
                </Card.Body>
            </Container>
        </div>
    );
}