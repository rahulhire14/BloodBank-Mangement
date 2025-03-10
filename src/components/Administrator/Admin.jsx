import React from "react";
import { Link, useNavigate } from "react-router-dom";
import "./forAdmin.css";

function AdminDashboard() {
  const navigate = useNavigate(); 

    const handleDasboard = () => {
        navigate("/dashboard"); 
    };
  return (
    <div className="admin-container">
      {/* Sidebar */}
      <aside className="sidebar">
        <h2>Admin Panel</h2>
        <nav>
          <ul>
            <li><Link to="/dashboard"   onClick={handleDasboard}>📊 Dashboard</Link></li>
            
            <li><Link to="/logout">🚪 Logout</Link></li>
          </ul>
        </nav>
      </aside>

      {/* Main Content */}
      <main className="main-content">
        <header>
          <h1>Welcome, Admin</h1>
          <p>Manage donors and blood requests efficiently.</p>
        </header>

        {/* Dashboard Cards */}
        <div className="dashboard-cards">
          <div className="card">
            <h3>Total Users</h3>
            <p>120</p>
          </div>
          <div className="card">
            <h3>Registered Donors</h3>
            <p>85</p>
          </div>
          <div className="card">
            <h3>Pending Requests</h3>
            <p>15</p>
          </div>
        </div>
      </main>
    </div>
  );
}

export default AdminDashboard;



