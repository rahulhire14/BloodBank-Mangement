import axios from "axios";
import React, { useState } from "react";
import "./ForbyBlood.css";

const FindBloodStock = () => {
  const [bloodGroup, setBloodGroup] = useState("");
  const [stockData, setStockData] = useState([]);
  const [error, setError] = useState("");

  const handleSearch = async () => {
    try {
      const response = await axios.get(`http://localhost:8084/api/bloodStock/${bloodGroup}`);
      console.log("API Response:", response.data);

      if (!Array.isArray(response.data)) {
        setStockData([response.data]); // Convert object to array if necessary
      } else {
        setStockData(response.data);
      }

      setError("");
    } catch (err) {
      console.error("Error fetching data:", err);
      setStockData([]);
      setError("Blood group not found!");
    }
  };

  return (
    <div>
      <h2>Find Blood Stock</h2>
      
      <select value={bloodGroup} onChange={(e) => setBloodGroup(e.target.value)}>
        <option value="">Select Blood Group</option>
        <option value="A+">A+</option>
        <option value="A-">A-</option>
        <option value="B+">B+</option>
        <option value="B-">B-</option>
        <option value="O+">O+</option>
        <option value="O-">O-</option>
        <option value="AB+">AB+</option>
        <option value="AB-">AB-</option>
      </select>
      
      <button onClick={handleSearch}>Search</button>

      {error && <p style={{ color: "red" }}>{error}</p>}

      {stockData.length > 0 && (
        <table border="1">
          <thead>
            <tr>
              <th>Blood Group</th>
              <th>Units Available</th>
              <th>Plasma Amount</th>
              <th>RBC Amount</th>
              <th>Platelets Amount</th>
            </tr>
          </thead>
          <tbody>
            {stockData.map((stock, index) => (
              <tr key={index}>
                <td>{stock.bloodGroup}</td>
                <td>{stock.unit}</td>
                <td>{stock.plasmaAmount}</td>
                <td>{stock.rbcAmount}</td>
                <td>{stock.plateletsAmount}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default FindBloodStock;
