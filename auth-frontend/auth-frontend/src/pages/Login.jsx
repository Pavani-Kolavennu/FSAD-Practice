import { useState } from "react";
import API from "../api/api";
import { useNavigate } from "react-router-dom";

const Login = () => {
  const [data, setData] = useState({
    email: "",
    password: ""
  });

  const navigate = useNavigate();

  const handleChange = (e) => {
    setData({ ...data, [e.target.name]: e.target.value });
  };

  const handleLogin = async () => {
    try {
      const res = await API.post("/login", data);
      alert(res.data);

      if (res.data === "Login successful!") {
        navigate("/dashboard");
      }
    } catch {
      alert("Login failed");
    }
  };

  return (
    <div>
      <h2>Login</h2>
      <input name="email" placeholder="Email" onChange={handleChange} />
      <br />
      <input name="password" type="password" placeholder="Password" onChange={handleChange} />
      <br />
      <button onClick={handleLogin}>Login</button>
    </div>
  );
};

export default Login;