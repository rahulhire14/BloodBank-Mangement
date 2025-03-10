import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./forUpdateDonor.css";

function DonorUpdate() {
  const navigate = useNavigate();

  
  const [donor, setDonor] = useState({
    id: "",
    name: "",
    address: "",
    contactNumber: "",
    gender: "",
    email: "",
  });

  const [searchId, setSearchId] = useState(""); // ID input for searching

  // Fetch donor details by ID
  const fetchDonorById = () => {
    if (!searchId.trim()) {
      alert("Please enter a donor ID!");
      return;
    }

    axios.get(`http://localhost:8084/api/donor/${searchId}`)
      .then(response => {
        setDonor(response.data);
      })
      .catch(error => {
        console.error("Error fetching donor:", error);
        alert("Donor not found!");
      });
  };

  
  const handleChange = (e) => {
    setDonor({ ...donor, [e.target.name]: e.target.value });
  };

  
  const handleSubmit = (e) => {
    e.preventDefault();

    axios.put(`http://localhost:8084/api/donor/update/${donor.id}`, donor)
      .then(response => {
        alert("Donor updated successfully!");
        navigate("/donors"); // Redirect after success
      })
      .catch(error => {
        console.error("Error updating donor:", error);
        alert("Update failed!");
      });
  };

  return (
    <div className="update-container">
      <h2>Search Donor by ID</h2>
      
      <div className="search-container">
        <input
          type="text"
          placeholder="Enter Donor ID"
          value={searchId}
          onChange={(e) => setSearchId(e.target.value)}
        />
        <button onClick={fetchDonorById}>Search</button>
      </div>

      {donor.id && (
        <>
          <h2>Update Donor Details</h2>
          <form onSubmit={handleSubmit}>
            <label>ID:</label>
            <input type="text" name="id" value={donor.id} disabled />

            <label>Name:</label>
            <input type="text" name="name" value={donor.name} onChange={handleChange} required />

            <label>Address:</label>
            <input type="text" name="address" value={donor.address} onChange={handleChange} required />

            <label>Contact Number:</label>
            <input type="text" name="contactNumber" value={donor.contactNumber} onChange={handleChange} required />

            <label>Email:</label>
            <input type="email" name="email" value={donor.email} onChange={handleChange} required />

            <label>Gender:</label>
            <select name="gender" value={donor.gender} onChange={handleChange} required>
              <option value="">Select</option>
              <option value="Male">Male</option>
              <option value="Female">Female</option>
              <option value="Other">Other</option>
            </select>

            <button type="submit">Update Donor</button>
          </form>
        </>
      )}
    </div>
  );
}

export default DonorUpdate;
