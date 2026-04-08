import React, { useState } from "react";

const Say = () => {
  const [message, setMessage] = useState();
  const [color, setColor] = useState();
  let message2 = "";

  return (
    <>
      <button
        onClick={() => {
          setMessage("안녕하세요.");
          message2 = "안녕하세요.";
        }}
      >
        입장
      </button>
      <button
        onClick={() => {
          setMessage("안녕히가세요.");
          message2 = "안녕히가세요.";
        }}
      >
        퇴장
      </button>
      <h2 style={{ color }}>
        {message}
        {message2}
      </h2>
      <button
        style={{ color: "red" }}
        onClick={() => {
          setColor("red");
        }}
      >
        빨간색
      </button>
      <button
        style={{ color: "green" }}
        onClick={() => {
          setColor("green");
        }}
      >
        초록색
      </button>
      <button
        style={{ color: "blue" }}
        onClick={() => {
          setColor("blue");
        }}
      >
        파랑색
      </button>
    </>
  );
};

export default Say;
