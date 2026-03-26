import { useState } from "react";
import API from "../api/api";
import { useNavigate } from "react-router-dom";

const Register = () => {
  const [form, setForm] = useState({
    name: "",
    email: "",
    password: ""
  });

  const navigate = useNavigate();

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async () => {
    try {
      const res = await API.post("/register", form);
      alert(res.data);
      navigate("/verify");
    } catch {
      alert("Error registering user");
    }
  };

  return (
    <div>
      <h2>Register</h2>
      <input name="name" placeholder="Name" onChange={handleChange} />
      <br />
      <input name="email" placeholder="Email" onChange={handleChange} />
      <br />
      <input name="password" type="password" placeholder="Password" onChange={handleChange} />
      <br />
      <button onClick={handleSubmit}>Register</button>
    </div>
  );
};

export default Register;