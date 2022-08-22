import React, { useEffect, useState } from "react";
import { Card, Container, Table, ButtonGroup, Button } from "react-bootstrap";
import axios from "axios";
import {Link} from 'react-router-dom'

export default function StudentList(props) {
  const [patients, setPatients] = useState([]);

  useEffect(() => {
    getPatients();
  }, []);

  let getPatients = () => {
    axios
      .get("http://localhost:8080/listpatient")
      .then((response) => setPatients(response.data))
      .catch((error) => alert(error));
  };

  let deletePatient = (patientId) => {
    axios.delete("http://localhost:8080/patient/"+patientId)
    .then(response=> {
      if (response.data !== null){
        props.showAlert("success", "Record deleted successfully")
        setPatients(patients.filter(patient=>patient.id!==patientId));
      }
    })
  }

  return (
    <div className="my-3">
      <Container>
        <Card.Header>
          <h3>Patientss List</h3>
        </Card.Header>
        <Card.Body>
          <Table striped bordered hover>
            <thead>
              <tr>
                <th>Patient Id</th>
                <th>Patient Name</th>
                <th>Patient Address</th>
                <th>Age</th>
                <th>Edit/Delete</th>
              </tr>
            </thead>
            <tbody>
              {patients.length === 0 ? (
                <tr>
                  <td colSpan={3}>{patients.length} Patients Available!!!</td>
                </tr>
              ) : (
                patients.map((patient)=>
                <tr key={patient.id}>
                  <td>{patient.id}</td>
                  <td>{patient.name}</td>
                  <td>{patient.age}</td>
                  <td>{patient.address}</td>
                  <td>
                    <ButtonGroup>
                      <Link to={"/patient/"+patient.id}><Button size="sm" variant="outline-primary"></Button></Link>{ ' '}
                      <Button size="sm" variant="outline-danger" onClick={deletePatient.bind(this,patient.id)}></Button>
                      {/* <Button size="sm" variant="outline-danger" onClick={()=>deleteStudent(student.id)}><FontAwesomeIcon icon={faTrash}> Delete </FontAwesomeIcon></Button> */}
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