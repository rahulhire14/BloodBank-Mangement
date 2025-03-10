import React, { useEffect, useState } from "react";
import "./forAllBlood.css";

const BloodStock = () => {
  const [bloodStock, setBloodStock] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8084/api/bloodStock")
      .then((response) => response.json())
      .then((data) => setBloodStock(data))
      .catch((error) => console.error("Error fetching data:", error));
  }, []);

  return (
    <div className="blood-stock-container">
      <h2>Blood Stock Inventory</h2>
      <table>
        <thead>
          <tr>
            <th>Blood Group</th>
            <th>Total Units</th>
            <th>RBC Amount</th>
            <th>Plasma Amount</th>
            <th>Platelets Amount</th>
          </tr>
        </thead>
        <tbody>
          {bloodStock.length > 0 ? (
            bloodStock.map((stock) => (
              <tr key={stock.id}>
                <td>{stock.bloodGroup}</td>
                <td>{stock.unit}</td>
                <td>{stock.rbcAmount || "N/A"}</td>
                <td>{stock.plasmaAmount || "N/A"}</td>
                <td>{stock.plateletsAmount || "N/A"}</td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="5" className="no-data">No data available</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default BloodStock;
