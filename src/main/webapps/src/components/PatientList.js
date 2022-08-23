import React, { useEffect, useState } from "react";
import { Card, Container, Table, ButtonGroup, Button } from "react-bootstrap";
import axios from "axios";
import {Link} from 'react-router-dom'

export default function PatientList(props) {
  const [patient, setPatient] = useState([]);

  useEffect(() => {
    getpatient();
  }, []);

  let getpatient = () => {
    axios
      .get("http://localhost:8080/patient")
      .then((response) => setPatient(response.data))
      .catch((error) => alert(error));
  };

  let deletePatient = (patientId) => {
    axios.delete("http://localhost:8080/patientRecord/"+patientId)
    .then(response=> {
      if (response.data !== null){
        props.showAlert("success", "Record deleted successfully")
        setPatient(patient.filter(patient=>patient.patientid!==patientId));
      }
    })``
  }

  return (
    <div className="my-3">
      <Container>
        <Card.Header>
          <h3>Patient List</h3>
        </Card.Header>
        <Card.Body>
          <Table striped bordered hover>
            <thead>
              <tr>
                <th>patient Id</th>
                <th>patient Name</th>
                <th>patient Address</th>
                <th>Edit/Delete</th>
              </tr>
            </thead>
            <tbody>
              {patient.length === 0 ? (
                <tr>
                  <td colSpan={3}>{patient.length} Patient Available!!!</td>
                </tr>
              ) : (
                patient.map((patient)=>
                <tr key={patient.patientId}>
                  <td>{patient.patientId}</td>
                  <td>{patient.name}</td>
                  <td>{patient.address}</td>
                  <td>
                    <ButtonGroup>
                      <Link to={"/patientRecord/"+patient.patientId}><Button size="sm" variant="outline-primary"> Edit </Button></Link>{ ' '}
                      <Button size="sm" variant="outline-danger" onClick={deletePatient.bind(this,patient.id)}> Delete </Button>
                      </ButtonGroup>
                  </td>
                </tr>
                )
              )}
            </tbody>
          </Table>
        </Card.Body>
      </Container>
    </div>
  );
}
