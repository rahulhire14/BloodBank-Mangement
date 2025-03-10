import axios from "axios";
import React, { useState } from "react";
import { Link } from "react-router-dom";
import "./forDonor.css";

function DonorPage() {
  const [donor, setDonor] = useState({
    name: "",
    bloodGroup: "",
    gender: "",
    contactNumber: "",
    address: "",
    email: "",
    unit: "",
    splitBlood: false,
    lastDonation: "",
  });

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setDonor((prev) => ({
      ...prev,
      [name]: type === "checkbox" ? checked : value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post("http://localhost:8084/api/donor/add", donor);
      alert("Donor registered successfully!");
      console.log(response.data);
    } catch (error) {
      console.error("Error registering donor:", error);
      alert("Failed to register donor.");
    }
  };

  return (
    <div>
      {/* ✅ Navbar */}
      <nav className="navbar">
        <div className="logo">
          <h1>bloodLine</h1>
        </div>
        <div className="nav-links">
          <Link to="/">Home</Link>
          <Link to="/donor-registration">Register as Donor</Link>
          <Link to="/seeker">Request Blood</Link>
        </div>
      </nav>

      {/* ✅ Donor Registration Form */}
      <div className="page-container">
        <form className="registerForm" onSubmit={handleSubmit}>
          <h2>🩸 Donor Registration Form</h2>

          {/* Donor Name */}
          <div className="input-group">
            <label>Donor Name</label>
            <input type="text" name="name" value={donor.name} onChange={handleChange} required />
          </div>

          {/* Blood Group */}
          <div className="input-group">
            <label>Blood Group</label>
            <select name="bloodGroup" value={donor.bloodGroup} onChange={handleChange} required>
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

          {/* Gender */}
          <div className="input-group">
            <label>Gender</label>
            <div className="radio-group">
              <label>
                <input type="radio" name="gender" value="Male" checked={donor.gender === "Male"} onChange={handleChange} />
                Male
              </label>
              <label>
                <input type="radio" name="gender" value="Female" checked={donor.gender === "Female"} onChange={handleChange} />
                Female
              </label>
            </div>
          </div>

          {/* Contact Number */}
          <div className="input-group">
            <label>Contact Number</label>
            <input type="tel" name="contactNumber" value={donor.contactNumber} onChange={handleChange} required />
          </div>

          {/* Email */}
          <div className="input-group">
            <label>Email</label>
            <input type="email" name="email" value={donor.email} onChange={handleChange} required />
          </div>

          {/* Address */}
          <div className="input-group">
            <label>Address</label>
            <input type="text" name="address" value={donor.address} onChange={handleChange} required />
          </div>

          {/* Last Donation Date */}
          <div className="input-group">
            <label>Last Donation Date</label>
            <input type="date" name="lastDonation" value={donor.lastDonation} onChange={handleChange} />
          </div>

          {/* Blood Units */}
          <div className="input-group">
            <label>Blood Units (ml)</label>
            <input type="number" name="unit" value={donor.unit} onChange={handleChange} min="1" />
          </div>

          {/* Split Blood Option */}
          <div className="input-group">
            <label>Split Blood?</label>
            <input type="checkbox" name="splitBlood" checked={donor.splitBlood} onChange={handleChange} />
          </div>

          {/* Submit Button */}
          <button type="submit" className="submit-btn">
            ✅ Register as Donor
          </button>
        </form>
      </div>
    </div>
  );
}

export default DonorPage;
