import './App.css';
import NavBar from "./Components/NavBar";
import AddPatient from "./Components/AddPatient";
import ListPatient from "./Components/ListPatient";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import {Container} from "react-bootstrap";

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
