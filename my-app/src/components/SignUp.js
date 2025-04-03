import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import '../App.css';

const SignUp = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [userid, setUserId] = useState('');
    const [successMessage, setSuccessMessage] = useState('');
    const [failedMessage, setFailedMessage] = useState('');

    const navigate = useNavigate();

    const handleUsernameChange = (e) => {
        setUsername(e.target.value);
    };

    const handleUserIdChange = (e) => {
        setUserId(e.target.value);
    };

    const handlePasswordChange = (e) => {
        setPassword(e.target.value);
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        fetch('http://localhost:8080/demo/signUp', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ username, userid, password }),
        })
            .then((response) => {
                if(response.status === 200) {
                    setSuccessMessage('User created successfully');
                }
                return response.json();
            })
            .then((data) => {
                console.log(data);
            })
            .catch((error) => {
                if(error.status ===!200) {
                    setFailedMessage('Something went wrong..try again!');
                }
                console.error('Error:', error);
            });
    };

    return (
        <div>
            <h1 id="header">Welcome to Online Learning App</h1>
            <div className="login-container">
                <h2>Create Login for your account</h2>
                <form onSubmit={handleSubmit}>
                    <label>
                        Name: <br />
                        <input type="text" value={username} onChange={handleUsernameChange} required />
                    </label>
                    <br />
                    <br />
                    <label>
                        Userid: <br />
                        <input type="text" value={userid} onChange={handleUserIdChange} required />
                    </label>
                    <br />
                    <br />
                    <label>
                        Password: <br />
                        <input type="password" value={password} onChange={handlePasswordChange} required />
                    </label>
                    <br />
                    <br />
                    <div className="login-container-btn">
                        <button type="submit">Sign Up</button>
                        <button type="button" onClick={() => navigate("/login")}>Go to Login</button>
                    </div>
                    <br />
                    <br />
                    {successMessage && <p style={{ color: 'green' }}>{successMessage}</p>}
                    {failedMessage && <p style={{ color: 'red' }}>{failedMessage}</p>}
                </form>
            </div>
        </div>
    );
};

export default SignUp;