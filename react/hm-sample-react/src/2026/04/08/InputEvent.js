import React, { useState } from "react";

const InputEvent = () => {
  const [message, setMessage] = useState("");
  const changeMage = (e) => {
    setMessage(e.target.value);
  };

  const reset = () => {
    setMessage("");
  };
  return (
    <>
      <h2>{message}</h2>
      <input type="text" onChange={changeMage} value={message}></input>
      <button onClick={reset}>초기화</button>
    </>
  );
};

export default InputEvent;
