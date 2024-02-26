import React, { useState } from "react";
import axios from "axios";
import {
  unameValidator,
  passwordValidator,
} from "../components/regexValidator";
import { useNavigate } from "react-router-dom";
import "./Login.css";

const Login = () => {
  const navigate = useNavigate();
  const [data, setData] = useState({
    username: "",
    password: "",
  });

  const [errorMessage, seterrorMessage] = React.useState("");
  const [successMessage, setsuccessMessage] = React.useState("");

  const { username, password } = data;

  const handleChange = (e) => {
    e.preventDefault();
    setData({ ...data, [e.target.name]: e.target.value });
  };

  const formSubmitter = (e) => {
    e.preventDefault();
    setsuccessMessage("");
    // if (!unameValidator(data.username))
    //   return seterrorMessage("Please enter valid user id");

    // if (!passwordValidator(data.password))
    //   return seterrorMessage(
    //     "Password should have minimum 8 character with the combination of uppercase, lowercase, numbers and specialcharaters"
    //   );
    //setsuccessMessage('Successfully Validated');
    // if(data.username !== 'Sejal@_1' || data.password !== 'Pass@123')
    axios.get(
      'http://localhost:8081/lms/checkAuth',
      {
        params: {
          id: 'sourabh',
          password: 'abcd123'
        },
        headers: { 'Content-Type': 'text/plain' },
      }
    ).then((res) => {
      if (res.data === 'noAuth') {
        seterrorMessage('Invalid Username or Password 1');
      } else if (res.data === 'noUser') {
        seterrorMessage('Invalid Username or Password 2');
      } else if (res.data === 'authPass') {
        navigate('/dashboard');
      }
    }).catch((err) => {
      console.error('Error:', err); // Log the error
      seterrorMessage('Invalid username or password catch');
    });
    //  return seterrorMessage('Invalid username or password');

    // navigate('/dashboard')
  };

  return (
    <div className="context">
      <div className="container">
        <div
          className="hero d-flex gap-2 "
        >
          <div type="button" className="btn btn-dark w-100">
            Eployee LMS Platform
            <br></br>
            <p style={{ fontWeight: 8, color: "#41aef2" }}>Powered by Alpha</p>
          </div>



          {/* <button type="button" className="btn btn-light w-100">
            Employees
          </button>
          <button type="button" className="btn btn-light w-100">
            Edit
          </button>
          <button type="button" className="btn btn-light w-100">
            Add
          </button> */}
        </div>
        <div className="form-login">
          <form className="login" onSubmit={formSubmitter}>
            <h2 className="text-center mb-4">Login</h2>

            {errorMessage.length > 0 && (
              <div style={{ marginBottom: "10px", color: "red" }}>
                {errorMessage}
              </div>
            )}

            {successMessage.length > 0 && (
              <div style={{ marginBottom: "10px", color: "green" }}>
                {successMessage}
              </div>
            )}

            <div className="mb-3 custom-input">
              <label htmlFor="username" className="form-label">
                Username:
              </label>
              <input
                type="text"
                className="form-control"
                name="username"
                placeholder="Enter your username"
                id="username"
                value={username}
                onChange={handleChange}
              />
            </div>

            <div className="mb-3 custom-input">
              <label htmlFor="password" className="form-label">
                Password:
              </label>
              <input
                type="password"
                className="form-control"
                name="password"
                placeholder="Enter your password"
                id="password"
                value={password}
                onChange={handleChange}
              />
            </div>

            <button
              className="text-decoration-none btn btn-sm btn-dark"
              type="submit"
            >
              Submit
            </button>
          </form>
        </div>
        <div className="footer text-center py-3">
          <p>Made by Saurav❣️</p>
          <p>&copy; 2024 Alpha. All rights reserved.</p>
        </div>
      </div>
    </div>
  );
};

export default Login;
