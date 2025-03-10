import React from "react";
import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import AdminDashboard from "./components/Administrator/Admin.jsx";
import BloodStock from "./components/Administrator/allBlood.jsx";
import FindBloodStock from "./components/Administrator/byBlood.jsx";
import BloodInventory from "./components/Administrator/dashboard.jsx";
import DonorPage from "./components/Giver/DonorForm.jsx";
import DonorUpdate from "./components/Giver/UpdateDonor.jsx";
import DonorActions from "./components/Giver/option.jsx";
import Home from "./components/Homepagefldr/HomePage";
import Login from "./components/loginForm/LoginForm";
import SeekerPage from "./components/seeker/Seeker";
;

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/Homepage" element={<Home />} />
        <Route path ="/LoginForm"element={<Login/>}/>
        <Route path ="/Seeker"element={<SeekerPage/>}/>
        <Route path="/DonorForm" element={<DonorPage />} />
        <Route path="/Admin" element={<AdminDashboard />} />
        <Route path="/option" element={<DonorActions />} />
        <Route path="/UpdateDonor" element={< DonorUpdate/>} />
        <Route path="/dashboard" element={< BloodInventory/>} />
        <Route path="/allBlood" element={< BloodStock/>} />
        <Route path="/byBlood" element={< FindBloodStock/>} />
        


        

      </Routes>
    </Router>
  );
}

export default App;
