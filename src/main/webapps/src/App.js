import logo from './logo.svg';
import './App.css';


function App() {
  return (
      <Container>
        <Router>
          <NavBar/>
          <AddStudent/>
          <ListStudent/>
          <Routes>
            <Route path="/patient" element={<AddPatient/>} />
            <Route path="/listpatient" element={<ListPatient/>} />
          </Routes>
        </Router>
      </Container>
  );
}

export default App;
