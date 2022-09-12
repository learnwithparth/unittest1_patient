import './App.css';
import NavigationBar from "./components/NavigationBar";
import Footer from "./components/Footer";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import PatientList from "./components/PatientList";
import AddPatient from "./components/AddPatient";
import Container from "react-bootstrap/esm/Container";
import { Snackbar } from '@mui/material';
import Register from './components/Register';


function App() {
  return (
    <div className="App">
        <BrowserRouter>
<NavigationBar />.
        <Container>
        <Snackbar
                autoHideDuration={6000}
             
                message="Hello"
               />
            <Routes>
                <Route path='/addPatient' element={<AddPatient/>}></Route>
                <Route path='/register' element={<Register />}></Route>
                <Route path='/updatePatient/:patientId' element={<AddPatient />}></Route>
                <Route path='/showPatient' element={<PatientList/>}></Route>
            </Routes>
        </Container>
        <Footer />
        </BrowserRouter>
    </div>
  );
}

export default App;
