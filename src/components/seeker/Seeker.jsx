import axios from "axios";
import React, { useState } from "react";
import "./forSeeker.css";

function SeekerPage() {
  const [formData, setFormData] = useState({
    name: "",
    age: "",
    contact: "",
    address: "",
    hospital: "",
    bloodGroup: "",
    component: "",
    unitRequired: "",
    emergency: "",
    gender: "",
  });

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData({
      ...formData,
      [name]: type === "checkbox" ? checked : value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post("http://localhost:8084/api/seeker/request", formData, {
        headers: { "Content-Type": "application/json" },
      });

      alert(response.data); // Show response from backend
    } catch (error) {
      console.error("Error submitting form:", error);
      alert("Failed to submit request");
    }
  };

  return (
    <div className="page-container">
      <div className="navbar">
        <div className="logo">
          <h1>🩸 BloodLine</h1>
        </div>
        <div className="infolinks">
          <a href="/">Home</a>
          <a href="/">About Us</a>
        </div>
      </div>

      <div className="registerForm">
        <h2>🔴 Blood Request Form</h2>
        <form onSubmit={handleSubmit} className="form-container">
          <div className="form-row">
            <div className="input-group">
              <label>Blood Group</label>
              <select name="bloodGroup" value={formData.bloodGroup} onChange={handleChange}>
                <option value="">Select</option>
                <option value="A+">A+</option>
                <option value="B+">B+</option>
                <option value="AB+">AB+</option>
                <option value="O+">O+</option>
                <option value="A-">A-</option>
                <option value="B-">B-</option>
                <option value="AB-">AB-</option>
                <option value="O-">O-</option>
              </select>
            </div>

            <div className="input-group">
              <label>Component</label>
              <select name="component" value={formData.component} onChange={handleChange}>
                <option value="">Select</option>
                <option value="WHOLE_BLOOD">Whole Blood</option>
                <option value="PLASMA">Plasma</option>
                <option value="RBC">Red Blood Cells</option>
                <option value="PLATELETS">Platelets</option>
              </select>
            </div>

            <div className="input-group">
              <label>Units</label>
              <input type="number" name="unitRequired" value={formData.unitRequired} onChange={handleChange} />
            </div>
          </div>

          <div className="form-row">
            <div className="input-group">
              <label>Name</label>
              <input type="text" name="name" value={formData.name} onChange={handleChange} />
            </div>

            <div className="input-group">
              <label>Age</label>
              <input type="number" name="age" value={formData.age} onChange={handleChange} />
            </div>
          </div>

          <div className="form-row">
            <div className="input-group">
              <label>Contact</label>
              <input type="tel" name="contact" value={formData.contact} onChange={handleChange} />
            </div>

            <div className="input-group">
              <label>Address</label>
              <input type="text" name="address" value={formData.address} onChange={handleChange} />
            </div>
          </div>

          <div className="form-row">
            <div className="input-group">
              <label>Hospital</label>
              <input type="text" name="hospital" value={formData.hospital} onChange={handleChange} />
            </div>
          </div>

          <div className="form-row">
            <div className="input-group emergency">
              <input type="checkbox" name="emergency" checked={formData.emergency} onChange={handleChange} />
              <label>⚠️ Emergency Case</label>
            </div>
          </div>

          <div className="form-row">
            <div className="input-group gender">
              <label>Gender</label>
              <div className="gender-options">
                <input type="radio" id="male" name="gender" value="Male" checked={formData.gender === "Male"} onChange={handleChange} />
                <label htmlFor="male">Male</label>

                <input type="radio" id="female" name="gender" value="Female" checked={formData.gender === "Female"} onChange={handleChange} />
                <label htmlFor="female">Female</label>

                <input type="radio" id="other" name="gender" value="Other" checked={formData.gender === "Other"} onChange={handleChange} />
                <label htmlFor="other">Other</label>
              </div>
            </div>
          </div>

          <button type="submit" className="submit-btn">🚑 Submit Request</button>
        </form>
      </div>
    </div>
  );
}

export default SeekerPage;





