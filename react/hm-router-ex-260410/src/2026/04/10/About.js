import React from "react";
import { Link, useNavigate } from "react-router-dom";

const About = () => {
  const navigate = useNavigate();
  const handleMove = (name) => {
    navigate(`/home/profile/${name}`);
  };
  return (
    <>
      <p>about</p>
      <Link to="/home">home으로 이동</Link>
      <br />
      <button onClick={() => handleMove("홍길동")}>이동</button>
    </>
  );
};

export default About;
