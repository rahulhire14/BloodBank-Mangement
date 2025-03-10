import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./loginForm.css";

function Login() {
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post("http://localhost:8084/admin/login", {
        username,
        password,
      });

      if (response.status == 200) {
        navigate("/HomePage"); 
      }
    } catch (err) {
      setError("Invalid admin credentials!");
    }
  };

  return (
    <div className="login">
      <div className="log">
        <div className="title">
          <h1>Admin Login</h1>
        </div>
        <form onSubmit={handleSubmit}>
          <div className="user">
            <img src="/assets/icons8-user-24.png" alt="User Icon" height={19} width={19} />
            <label className="username">Username:</label>
            <input
              type="text"
              placeholder="Enter username"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              required
            />
          </div>
          <br />
          <div className="passerd">
            <img src="/assets/icons8-password-24.png" alt="Password Icon" height={19} width={19} />
            <label className="passwrd">Password:</label>
            <input
              type="password"
              placeholder="Enter password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <br />
          {error && <p className="error">{error}</p>}
          <div className="btnfrg">
            <button className="btn1" type="submit">Login</button>
            <br />
            <a className="fp" href="/">Forgot password?</a>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Login;

