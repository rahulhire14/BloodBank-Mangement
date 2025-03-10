import React from "react";
import { useNavigate } from "react-router-dom";
import "./forOption.css"; // Import the CSS file

function DonorActions() {
  const navigate = useNavigate();

  return (
    <div className="donor-container">
         <div className="navbar">
        <div className="logo">
          <h1>🩸 BloodLine</h1>
        </div>
        <div className="infolinks">
          <a href="/">Home</a>
          <a href="/">About Us</a>
        </div>
      </div>
      <h2>Donor Management</h2>
      <div className="button-group">
        <button onClick={() => navigate("/DonorForm")} className="action-btn register-btn">
          Register Donor
        </button>
        <button onClick={() => navigate("/UpdateDonor")} className="action-btn update-btn">
          Update Donor
        </button>
      </div>
    </div>
  );
}

export default DonorActions;

