import './App.css';
import Addpatient from './components/addpatient';
import Updatepatient from './components/updatepatient';
import Navbar from './components/navbar';
import Patientlist from './components/patientlist';
import { Routes, Route} from "react-router-dom";
function App() {
  return (
    <div className="App">
      <Navbar/>
      <Routes>
        <Route path="/" element={<Patientlist/>} />
        <Route path="addstudent" element={<Addpatient/>} />
        <Route path="editstudent" element={<Updatepatient/>} />
      </Routes>
    </div>
  );
}

export default App;
