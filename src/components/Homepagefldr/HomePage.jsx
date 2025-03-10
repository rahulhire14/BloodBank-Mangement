import React from 'react';
import { useNavigate } from "react-router-dom";
import "./cssForHomePage.css";

function Home() {
    const navigate = useNavigate(); 

    const handleLogout = () => {
        navigate("/LoginForm"); 
    };

    const handleSeeking = () => {
        navigate("/Seeker");
        
    };

    const handleGiver = () => {
        navigate("/option")
    };
    const handleAdmin= () => {
        navigate("/Admin");

    };

    return (
        <div className="homepage">

            <nav>
                <div className="navbar">
                    <div className="logo"><h1>BloodLine</h1></div>
                    <div className="infolinks">
                        <a href="/">Home</a>
                        <a href="/">About us</a>
                    </div>
                </div>
            </nav>

  
            <div className="sidebar">
                <div className="logout" onClick={handleLogout}>
                    <img src="/assets/icons8-logout-50.png" alt="Logout Icon" />
                    <a href="/">Logout</a>
                </div> 
            </div>

       
            <div className="main">
                <div className="seek" onClick={handleSeeking}>
                    <img src="/assets/icons8-blood-donation-64.png" alt="Seeker Icon" />
                    <p>Seeker</p>
                </div> 
                <div className="giver "onClick={handleGiver}> 
                    <img src="/assets/icons8-blood-donor-male-96.png" alt="Donor Icon" />
                    <p>Donor</p>
                </div>
                <div className="controller" onClick={handleAdmin}>
                    <img src="/assets/icons8-admin-80.png" alt="Admin Icon" />
                    <p>Admin</p>
                </div>
            </div>
        </div>
    );
}

export default Home;
