import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import React from "react";

function NavigationBar(props){
    return(
        <div>
            <Navbar bg="dark" variant="dark">
                <Container>
                    <Navbar.Brand href="/">{props.title}</Navbar.Brand>
                    <Nav className="me-auto">
                        <Nav.Link href="/addpatient">{props.menu1}</Nav.Link>
                        <Nav.Link href="/modifypatient">{props.menu2}</Nav.Link>
                    </Nav>
                </Container>
            </Navbar>
        </div>
    );
}

export default NavigationBar;