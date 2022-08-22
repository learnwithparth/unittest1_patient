
import './App.css';
import "./App.css";
import NavigationBar from "./Components/NavigationBar";
import Patient from "./Components/Patient";
import PatientList from "./Components/PatientList"
import Container from "react-bootstrap/Container";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";



function App() {
  return (
    <div className="App">
      <Router>
        <NavigationBar />
        <Container>
          <Routes>
            <Route path="patient" element={<Patient  />} />
            <Route
              path="patient/:patientId"
              element={<Patient  />}
            />
            <Route
              path="listPatients"
              element={<PatientList />}
            />
          </Routes>
        </Container>
      </Router>
    </div>
  );
}

export default App;
