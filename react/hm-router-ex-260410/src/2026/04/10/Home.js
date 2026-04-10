import React, { useState } from "react";
import { Outlet, useNavigate, useLocation } from "react-router-dom";
import { Container, Button } from "./Default_Css";

const Home = () => {
  const [job, setJob] = useState("");
  const navigate = useNavigate();
  const location = useLocation();
  const data = location.state || {};
  const handelMove = () => {
    navigate(`profile`, {
      state: {
        job: job,
      },
    });
  };
  return (
    <>
      <p>hopme</p>
      <input type="text" value={job} onChange={(e) => setJob(e.target.value)} />
      <Button
        onClick={handelMove}
        m={"0 0 0 10px"}
        p={"10px 30px"}
        bgc={"blue"}
        fc={"white"}
        br={"10px"}
      >
        이동
      </Button>
      <p>{data.email}</p>
      <p>{data.pwd}</p>
      <Outlet />
    </>
  );
};

export default Home;
