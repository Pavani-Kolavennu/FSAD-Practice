import { useState } from "react";
import API from "../api/api";
import { useNavigate } from "react-router-dom";

const VerifyOtp = () => {
  const [data, setData] = useState({
    email: "",
    otp: ""
  });

  const navigate = useNavigate();

  const handleChange = (e) => {
    setData({ ...data, [e.target.name]: e.target.value });
  };

  const handleVerify = async () => {
    try {
      const res = await API.post("/verify", data);
      alert(res.data);
      navigate("/login");
    } catch (err) {
      alert("Invalid OTP");
    }
  };

  return (
    <div>
      <h2>Verify OTP</h2>
      <input name="email" placeholder="Email" onChange={handleChange} />
      <br />
      <input name="otp" placeholder="OTP" onChange={handleChange} />
      <br />
      <button onClick={handleVerify}>Verify</button>
    </div>
  );
};

export default VerifyOtp;