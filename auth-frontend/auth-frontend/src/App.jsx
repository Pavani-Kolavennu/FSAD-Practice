import { BrowserRouter, Routes, Route } from "react-router-dom";

import Register from "./pages/Register";
import VerifyOtp from "./pages/VerifyOtp";
import Login from "./pages/Login";
import Dashboard from "./pages/Dashboard";

const App = () => {
  return (
    <>
      <h1>Authentication App</h1>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Register />} />
          <Route path="/verify" element={<VerifyOtp />} />
          <Route path="/login" element={<Login />} />
          <Route path="/dashboard" element={<Dashboard />} />
        </Routes>
      </BrowserRouter>
    </>
  );
};

export default App;