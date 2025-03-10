import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./dashboard.css";

const BloodInventory = () => {
  const [showOptions, setShowOptions] = useState(false);
  const navigate = useNavigate();

  return (
    <div className="dashboard-container">
      {/* Sidebar */}
      

      {/* Main Content */}
      <div className="main-content">
        <nav className="navbar">
          <div className="logo">
            <h1>BloodLine Dashboard</h1>
          </div>
          <div className="infolinks">
            <a href="/">Home</a>
            <a href="/">About Us</a>
          </div>
        </nav>

        <button className="inventory-btn" onClick={() => setShowOptions(!showOptions)}>
          Blood Inventory
        </button>

        {showOptions && (
          <div className="options">
            <button onClick={() => navigate("/allBlood")}>
              Show all Inventory
            </button>
            <button onClick={() => navigate("/byBlood")}>
              Get Blood by Blood Group
            </button>
            <button onClick={() => navigate("/blood/register")}>
              Register Blood
            </button>
          </div>
        )}
      </div>
    </div>
  );
};

export default BloodInventory;
