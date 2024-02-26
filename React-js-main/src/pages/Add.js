import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Dashboard.css";

const generateRandomId = () => {
  return Math.floor(Math.random() * 1000000).toString();
};

function Add() {
  const [inputData, setInputData] = useState({
    id: generateRandomId(),
    firstname: "",
    lastname: "",
    emai: "",
    sex: "",
    salary: "",
    department: "",
  });

  const navigate = useNavigate();

  function handleSubmit(e) {
    e.preventDefault();
    axios
      .post("http://localhost:8081/lms/employee", inputData)
      .then((res) => {
        navigate("/dashboard");
        window.location.reload();
      })
      .catch((err) => console.log(err));
  }

  const goBack = (e) => {
    e.preventDefault();
    window.history.back();
  };

  const logout = (e) => {
    e.preventDefault();
    navigate("/");
    window.location.reload();
  };

  return (
    <div className="dash-content">
      <div className="container">
        <div
          className="btn-group btn-group-lg d-flex gap-2"
          role="group"
          aria-label="...."
        >
          <button className="btn btn-dark" value={""} onClick={goBack}>
            Back
          </button>
          <button
            type="button"
            className="btn btn-light w-100"
            onClick={() => navigate("/dashboard")}
          >
            Employees
          </button>
          {/* <button type="button" className="btn btn-dark w-100">
            Edit
          </button>
          <button type="button" className="btn btn-dark w-100 active">
            Add
          </button> */}
          <button
            type="button"
            className="btn btn-light w-100"
            data-bs-toggle="modal"
            data-bs-target="#staticBackdrop"
          >
            Log Out
          </button>

          <div
            class="modal fade"
            id="staticBackdrop"
            data-bs-backdrop="static"
            data-bs-keyboard="false"
            tabindex="-1"
            aria-labelledby="staticBackdropLabel"
            aria-hidden="true"
          >
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h1 class="modal-title fs-7" id="staticBackdropLabel">
                    Log Out
                  </h1>
                  <button
                    type="button"
                    class="btn-close"
                    data-bs-dismiss="modal"
                    aria-label="Close"
                  ></button>
                </div>
                <div class="modal-body">
                  <h6>
                    Are you sure you want to logout? If yes, then click on yes.
                  </h6>
                </div>
                <div class="modal-footer">
                  <button
                    type="button"
                    class="btn btn-secondary"
                    data-bs-dismiss="modal"
                  >
                    Cancel
                  </button>
                  <button
                    type="button"
                    class="btn btn-primary"
                    onClick={logout}
                  >
                    Yes!
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
        <br />
        <div
          className="d-flex"
          style={{
            backgroundColor: "rgb(255,192,203)",
            border: "1px solid black",
          }}
        >
          <form onSubmit={handleSubmit}>
            <h1>Add New Employee Data</h1>
            <div>
              <label htmlFor="Employee ID">Employee ID</label>
              <input
                type="text"
                name="id"
                className="form-control"
                placeholder="Enter Employee ID"
                value={inputData.id}
                onChange={(e) => {
                  setInputData({ ...inputData, id: e.target.value });
                }}
                readOnly 
              />
            </div>
            <div>
              <label htmlFor="firstname">First Name</label>
              <input
                type="text"
                name="firstname"
                className="form-control"
                placeholder="Enter Name"
                required
                onChange={(e) =>
                  setInputData({ ...inputData, firstname: e.target.value })
                }
              />
            </div>
            <div>
              <label htmlFor="lastname">Last Name</label>
              <input
                type="text"
                name="lastname"
                className="form-control"
                placeholder="Enter Name"
                required
                onChange={(e) =>
                  setInputData({ ...inputData, lastname: e.target.value })
                }
              />
            </div>
            <div>
              <label htmlFor="email">Email</label>
              <input
                type="text"
                name="email"
                className="form-control"
                placeholder="Enter Name"
                required
                onChange={(e) =>
                  setInputData({ ...inputData, email: e.target.value })
                }
              />
            </div>
            <div>
              <label htmlFor="sex">Sex</label>
              <select
                id="sex"
                name="sex"
                className="form-control"
                placeholder="Enter M or F"
                required
                onChange={(e) => setInputData({ ...inputData, sex: e.target.value })}
              >
                <option value="">select</option>
                <option value="Male">M</option>
                <option value="Female">F</option>
              </select>
            </div>

            <div>
              <label htmlFor="salary">Salary</label>
              <input
                type="text"
                name="salary"
                className="form-control"
                placeholder="Enter Salary"
                required
                onChange={(e) =>
                  setInputData({ ...inputData, salary: e.target.value })
                }
              />
            </div>
            <div>
              <label htmlFor="department">Department</label>
              <select
                type="text"
                name="department"
                className="form-control"
                required
                onChange={(e) =>
                  setInputData({ ...inputData, department: e.target.value })
                }
              >
                <option value={""}>Select One</option>
                <option value={"HR"}>HR</option>
                <option value={"Sales"}>Sales</option>
                <option value={"Accounts"}>Accounts</option>
                <option value={"IT"}>IT</option>
                <option value={"Finance"}>Finance</option>
                <option value={"Marketing"}>Marketing</option>
              </select>
            </div>
            <br />
            <button onClick={handleSubmit} className="btn btn-success">Add</button>
          </form>
        </div>
      </div>
    </div>
  );
}

export default Add;

// onClick={() => handleDelete(user.id)}>Delete</button>
// function handleDelete(id) {
//   const newList = data.filter( li => li.id !== id)
//   setData(newList)
// }
