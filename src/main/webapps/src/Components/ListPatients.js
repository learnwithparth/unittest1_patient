import {useEffect, useState} from "react";
import axios from "axios";
import {Container, Card, Table, Button} from "react-bootstrap";


export default function ListPatient() {

    const [patient, setPatient] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8080/patient")
            .then(response => setPatient(response.data))
            .catch(error => alert(error));
    }, []);

    let deleteRecord = (patientId) => {
        axios.delete("http://localhost:8080/patient/"+patientId)
            .then(response => {
                if(response.data != null)
                    alert("Record Deleted");
            });
    }

    return (
        <div className="my-3">
            <Container>
                <Card.Header>Patients Record</Card.Header>
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
                                    <Button variant="primary" onClick ={ () => deleteRecord(patient.patientId)}>Delete</Button>
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