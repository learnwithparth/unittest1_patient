import React, { useEffect, useState } from 'react'
import Table from 'react-bootstrap/Table';
import Card from 'react-bootstrap/Card';
import axios from 'axios'
import Button from 'react-bootstrap/Button'
import {Link} from 'react-router-dom'
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';

export default function PatientList() {
    const[patients,setPatients]=useState([])
    useEffect(()=>{
        axios.get('http://localhost:8080/patient')
            .then(response=>setPatients(response.data))
            .catch(error=>alert(error))
    })
    let deleteRec=(id,event)=>{
        event.preventDefault();
        axios.delete('http://localhost:8080/patient/'+id)
            .then(response=> alert(response.data))
            .catch(error=>alert(error))
    }
    return (
        <Card className="my-3">
            <Card.Header>Patient List</Card.Header>
            <div>
                <Table striped bordered hover size="sm">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Address</th>
                        <th>Edit/Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    {patients.map((patient)=>
                        <tr key={patient.patientId}>
                            <td>{patient.patientId}</td>
                            <td>{patient.name}</td>
                            <td>{patient.age}</td>
                            <td>{patient.address}</td>
                            <td><Link to={"/updatePatient/"+patient.patientId}><EditIcon /></Link>
                            {' '}<DeleteIcon color="error" onClick={deleteRec.bind(this,patient.patientId)} /></td>
                        </tr>)}
                    </tbody>
                </Table>
            </div>
            <Card.Footer>Information is upto Date</Card.Footer>
        </Card>
    )
}
