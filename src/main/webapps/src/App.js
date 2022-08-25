import './App.css';
import NavBar from "./Components/NavBar";
import Container from "react-bootstrap/Container";
import AddPatient from "./Components/AddPatient.dart";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import ListPatient from "./Components/ListPatients";

function App() {
  return (
      <div className="App">
          <Router>
              <NavBar/>
              <Container>
                  <Routes>
                      <Route
                          path="patient"
                          element={<AddPatient/>}
                      />
                      <Route
                          path="listPatients"
                          element={<ListPatient/>}
                      />
                  </Routes>
              </Container>
          </Router>
      </div>
  );
}

export default App;
