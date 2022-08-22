import React, { Component } from 'react'
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';

export default class AddPatient extends Component {
  render() {
    return (
      <div>
        <Container className="mt-3">
          <Form onSubmit={savePatient}>
            <Form.Group className="mb-3" controlId="formBasicEmail">
              <Form.Label>Patient ID</Form.Label>
              <Form.Control type="text" placeholder="Enter patient id" />
            </Form.Group>

            <Form.Group className="mb-3" controlId="formBasicEmail">
              <Form.Label>Patient Name</Form.Label>
              <Form.Control type="text" placeholder="Enter patient name" />
            </Form.Group>
            
            <Form.Group className="mb-3" controlId="formBasicEmail">
              <Form.Label>Patient Age</Form.Label>
              <Form.Control type="text" placeholder="Enter patient age" />
            </Form.Group>

            <Form.Group className="mb-3" controlId="formBasicEmail">
              <Form.Label>Patient Address</Form.Label>
              <Form.Control type="text" placeholder="Enter patient address" />
            </Form.Group>
            <Button variant="primary" type="submit">
              Submit
            </Button>
          </Form>
        </Container>
      </div>
    )
  }
}
