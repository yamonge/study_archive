import React from "react";
import { Route, Routes } from "react-router-dom";
import SignUpPage from "./pages/SignUpPage";
import LoginPage from "./pages/Login";
import MainPage from "./pages/MainPage";

function App() {
  return (
    <Routes>
      <Route path="/signup" element={<SignUpPage />} />
      <Route path="/login" element={<LoginPage />} />
      <Route path="/" element={<MainPage />} />
    </Routes>
  );
}

export default App;
