import React from 'react'
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import {Link} from 'react-router-dom'
export default function NavigationBar() {
    return (
        <div>
            <Navbar bg="dark" variant="dark">
                <Container>
                    <Navbar.Brand href="/">Navbar</Navbar.Brand>
                    <Nav className="me-auto">
                        <Link to="/addPatient" className='nav-link'>Add Patient</Link>
                        <Link to="/showPatient" className='nav-link'>Patient List</Link>
                        <Link to="/register" className='nav-link'>Register</Link>
                    </Nav>
                </Container>
            </Navbar>
        </div>
    )
}
