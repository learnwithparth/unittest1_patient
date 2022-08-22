import React from 'react'
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/esm/Container';
import Form from 'react-bootstrap/Form';

function Addpatient() {
  return (
    
    <Form>
      <Container>
      <Form.Group className="mb-3" controlId="formBasicEmail">
        <Form.Label>Patient Id</Form.Label>
        <Form.Control type="Id" placeholder="Enter patient Id" />
      </Form.Group>

      <Form.Group className="mb-3" controlId="formBasicPassword">
        <Form.Label>Name</Form.Label>
        <Form.Control type="Name" placeholder="Enter Patient Name" />
      </Form.Group>

      <Form.Group className="mb-3" controlId="formBasicPassword">
        <Form.Label>Address</Form.Label>
        <Form.Control type="Address" placeholder="Enter an Address" />
      </Form.Group>

      <Form.Group className="mb-3" controlId="formBasicPassword">
        <Form.Label>Age</Form.Label>
        <Form.Control type="Age" placeholder="Enter Patient Age" />
      </Form.Group>
      
      <Button variant="primary" type="submit">
        Submit
      </Button>
      </Container>
    </Form>
  )
}

export default Addpatient