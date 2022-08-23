import React, { useEffect, useState } from 'react'
import Card from 'react-bootstrap/Card'
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';
import axios from 'axios';
import { useNavigate, useParams } from 'react-router-dom';

export default function AddPatient() {
    const[patientId,setId]=useState();
    const[name,setName]=useState();
    const[age,setAge]=useState();
    const[address,setAddress]=useState();

    const {patientIds} =useParams();
    const navigate =useNavigate();

    const patient = {
        address:address,
        name:name,
        patientId:patientId,
        age:age,
    }

    let changeText=(event)=>{
        if(event.target.name==='id')
            setId(event.target.value);

        else if(event.target.name==='name')
            setName(event.target.value);

        else if(event.target.name==='age')
            setAddress(event.target.value)

        else if(event.target.name==='address')
            setAddress(event.target.value)
    }

    let saveStudent = (event) => {
        event.preventDefault();
        
          axios
            .post("http://localhost:8080/patient", patient)
            .then((response) => {
              if (response.data != null) {
                alert("success", "Record added successfully");
              }
            })
            .catch((error) => alert("danger", "Error"));
      };

    let addPatient = () => {
        if(patientIds===null)
        {
            axios.post("http://localhost:8080/patients",patient)
                .then(response=>{alert(response.data)})
                .catch(error=>alert(error));
        }
        else
        {
            axios.put("http://localhost:8080/patient"+patientIds,patient)
                .then(response=>alert(response.data))
                .catch(error=>alert(error))
        }

    }
    useEffect(()=>
    {
        if(patientIds!==null)
        {
            axios.get("http://localhost:8080/patient/"+patientIds)
                .then(response=>{
                    setId(response.data.id)
                    setName(response.data.name)
                    setAge(response.data.age)
                    setAddress(response.data.address)
                })
        }
    },[])
    return (

        <Card className='my-3'>

            <Card.Header>Enter details Here</Card.Header>
            <Container>
                <Form onSubmit={addPatient}>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>patientId</Form.Label>
                        <Form.Control name="patientId" value={patientId} type="patientId" placeholder="ID" onChange={changeText} />
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label>Name</Form.Label>
                        <Form.Control name="name" value={name} type="text" placeholder="Name" onChange={changeText}/>
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label>Age</Form.Label>
                        <Form.Control name="age" value={age} type="text" placeholder="Age" onChange={changeText}/>
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label>Address</Form.Label>
                        <Form.Control name="address" value={address} type="text" placeholder="Address" onChange={changeText} />
                    </Form.Group>

                    <Button variant="primary" type="submit" className='my-3'>
                        Submit
                    </Button>
                </Form>
            </Container>
            <Card.Footer>Thank You</Card.Footer>
        </Card>

    )
}
