import logo from './logo.svg';
import './App.css';
import NavigationBar from './components/NavigationBar';
import { BrowserRouter, Routes,Route } from 'react-router-dom';
import AddPatient from './components/AddPatient';
import PatientList from './components/PatientList';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <NavigationBar title="Patient Management System" menu1="AddPatient" menu2="Update/Delete"/>
        <Routes>
          <Route path="/addpatient" element={<AddPatient/>}></Route>
          <Route path="/modifypatient" element={<PatientList/>}></Route>
        </Routes>
      </BrowserRouter>

    </div>
  );
}

export default App;
