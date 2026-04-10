import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { Global } from "./GlobalCss";
import Login from "./2026/04/10/Login";
import Home from "./2026/04/10/Home";
import Profile from "./2026/04/10/Profile";
function App() {
  return (
    <>
      <Global />
      <Router>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/home" element={<Home />}>
            <Route path="profile" element={<Profile />} />
          </Route>
        </Routes>
      </Router>
    </>
  );
}

export default App;
